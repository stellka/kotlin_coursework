import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce

/*Порт разгрузки — порт распределительного центра, куда поступают пришедшие
на разгрузку грузовики и в котором осуществляется разгрузка грузовика.*/

class DischargePort {

    @OptIn(DelicateCoroutinesApi::class)
    private val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun unloadTruck() = runBlocking {

        repeat(3) {
            val randomTruck = TruckGenerator().randomTruckForDischarge
            if (randomTruck != null) {
                println("Максимальная грузоподъемность пришедшего на разгрузку грузовика: ${randomTruck.maxLoadCapacity}")
                println("Происходит выгрузка товаров на склад...")
                randomTruck.generateTruck()
                delay(10000)
                Warehouse().products = produce(context = Dispatchers.Default) {
                    while (randomTruck.timeOfDischarge > 0) {
                        for (element in randomTruck.baggage) {
                            println(send(element))
                            randomTruck.timeOfDischarge -= element.time
                        }
                    }
                } as Channel<Product>
            }
        }
    }
}
