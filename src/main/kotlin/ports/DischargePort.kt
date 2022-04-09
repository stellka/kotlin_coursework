package ports

import food.Warehouse
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import trucks.Truck

import trucks.TruckGenerator

/*Порт разгрузки — порт распределительного центра, куда поступают пришедшие
на разгрузку грузовики и в котором осуществляется разгрузка грузовика.*/

class DischargePort(private val truckGenerator: TruckGenerator, private val warehouse: Warehouse) {
    suspend fun sendTruck(channel: SendChannel<Truck>) {
        repeat(3) {
            val newTruck = truckGenerator.randomTruck
            println("Был сгенерирован грузовик с грузоподъемностью ${newTruck.maxLoadCapacity}")
            println("генерируютя товары для грузовика: ")
            truckGenerator.generateTruck(newTruck)
            channel.send(newTruck)
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
                    warehouse.products.send(element)
                    truck.timeOfDischarge -= element.time
                }
            }
        }
    }
}