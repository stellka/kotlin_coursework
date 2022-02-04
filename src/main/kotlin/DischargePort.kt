import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

/*Порт разгрузки — порт распределительного центра, куда поступают пришедшие
на разгрузку грузовики и в котором осуществляется разгрузка грузовика.*/

class DischargePort {

    private val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun unloadTruck() : Unit = withContext(scope.coroutineContext) {
        repeat(5) {
            val result = TruckGenerator().randomTruck
            if (result != null) {
                println("Максимальная грузоподъемность пришедшего на разгрузку грузовика: ")
                println(result.maxLoadCapacity)
                println("Происходит выгрузка товаров на склад...")
                result.generateTruck()
                println(result.baggage)
                while (result.timeOfDischarge < result.maxLoadCapacity) {
                    Warehouse().products = produce(context = Dispatchers.Default) {
                        for (element in result.baggage) {
                            println(element)
                            send(element)
                            result.baggage.remove(element)
                            result.timeOfDischarge -= element.time
                        }
                    } as Channel<Product>
                    delay(100000)

                }
            }
            coroutineContext.cancelChildren()
        }
    }
}