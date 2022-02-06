import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.random.Random

class TruckGenerator {

    @OptIn(DelicateCoroutinesApi::class)

    private val mutex = Mutex()
    suspend fun sendTruck(channel: SendChannel<Truck>) {
        mutex.withLock {
            repeat(3) {
                val randomTruckForDischarge = when (Random.nextInt(1, 4)) {
                    1 -> SmallSizedTruck()
                    2 -> FoodTruck()
                    3 -> MediumTruck()
                    4 -> LargeSizedTruck()
                    else -> null
                }//выбор рандомного грузовика для разгрузки товара
                println("Был сгенерирован грузовик с грузоподъемностью ${randomTruckForDischarge?.maxLoadCapacity}")
                channel.send(randomTruckForDischarge!!)
                println("Были сгенерированы товары для грузовика: ")
                randomTruckForDischarge.generateTruck()
                delay(10000)
            }
        }
    }
    suspend fun launchProcessor(channel: ReceiveChannel<Truck>) {
        for (truck in channel) {
           channel.receive()
        }
    }

    val randomTruckForLoading = when (Random.nextInt(1, 2)) {
        1 -> SmallSizedTruck()
        2 -> FoodTruck()
        else -> null
    } //выбор рандомного грузовика для загрузки товара

}
