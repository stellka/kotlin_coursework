import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/*Порт разгрузки — порт распределительного центра, куда поступают пришедшие
на разгрузку грузовики и в котором осуществляется разгрузка грузовика.*/

class DischargePort {
    private val mutex = Mutex()
    suspend fun unloadTruck(channel: ReceiveChannel<Truck>) {
        for (truck in channel) {
            while (truck.timeOfDischarge > 0) {
                for (element in truck.baggage) {
                    println("На склад отправлен товар: $element")
                    DistributionCenter().warehouse.products.send(element)
                    truck.timeOfDischarge -= element.time
                }
            }
        }
    }


    suspend fun launchProcessor(channel: ReceiveChannel<Product>) {
        mutex.withLock {
            for (product in channel) {
                channel.receive()
            }
        }
    }
}