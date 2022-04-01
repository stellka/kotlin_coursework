import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.random.Random

class LoadingPort {

    private val mutex = Mutex()
    suspend fun getTruck(channel: SendChannel<Truck>) {
        mutex.withLock {
            repeat(5) {
                val truck = TruckGenerator().randomTruck
                println("Был получен грузовик с грузоподъемностью ${truck.maxLoadCapacity}")
                channel.send(truck)
                delay(10000)
            }
        }
    }

    suspend fun loadTruck(channel: ReceiveChannel<Truck>) {
        mutex.withLock {
            for (truck in channel) {
                println("Происходит загрузка грузовиков...")
                while (truck.currentWeight < truck.maxLoadCapacity) {
                    for (element in DistributionCenter().warehouse.products) {
                        println("Со склада получен товар: $element")
                        DistributionCenter().warehouse.products.receive()
                        truck.currentWeight += element.weight
                    }
                }
            }
        }
    }
}

