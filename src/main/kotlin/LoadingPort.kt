import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.random.Random

class LoadingPort {

    private val mutex = Mutex()
    private val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun getElement(): Unit = withContext(scope.coroutineContext) {
        //код по получению элементов
        val randomItem = when (Random.nextInt(1, 10)) {
            1 -> Food.BREAD
            2 -> MediumSizedProduct.BYKE
            3 -> SmallSizedProduct.JEWELRY
            4 -> Food.MILK
            5 -> Food.POTATOES
            6 -> SmallSizedProduct.CANDLES
            7 -> SmallSizedProduct.PAPER
            8 -> MediumSizedProduct.GYROSKUTER
            9 -> LargeSizedProduct.FURNITURE
            10 -> LargeSizedProduct.WOOD
            else -> {
                null
            }
        }
        println(randomItem)

        val randomTruck = TruckGenerator().randomTruck

        println("Происходит загрузка товаров в грузовик...")
        mutex.withLock {
            for (element in Warehouse().products) {
                if (randomItem == element) {
                    println(element)
                    randomTruck?.addMass(element)
                }
                return@withLock element
            }
        }
        println(randomTruck?.baggage)

    }
}

