import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.random.Random

/*Порт разгрузки — порт распределительного центра, куда поступают пришедшие
на разгрузку грузовики и в котором осуществляется разгрузка грузовика.*/

class DischargePort {
    suspend fun sendTruck(channel: SendChannel<Truck>) {
        repeat(3) {
            val truck = TruckGenerator().randomTruck
            println("Был сгенерирован грузовик с грузоподъемностью ${truck.maxLoadCapacity}")
            println("генерируютя товары для грузовика: ")
            TruckGenerator().generateTruck(truck)
            channel.send(truck)
            //выбор рандомного грузовика для разгрузки товара
            delay(10000)
        }
    }

    suspend fun unloadTruck(channel: ReceiveChannel<Truck>) {
        for (truck in channel) {
            println("Происходит разгрузка грузовиков...")
            while (truck.timeOfDischarge > 0) {
                for (element in truck.baggage) {
                    println("На склад отправлен товар: $element")
                    DistributionCenter().warehouse.products.send(element)
                    truck.timeOfDischarge -= element.time
                }
            }
        }
    }
}