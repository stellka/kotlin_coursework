package ports

import food.Warehouse
import trucks.TruckGenerator
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import trucks.Truck

class LoadingPort(truckGenerator: TruckGenerator, private val warehouse : Warehouse) {

    private val mutex = Mutex()

    private val newTruck = truckGenerator.randomTruck

    suspend fun getTruck(channel: SendChannel<Truck>) {
        mutex.withLock {
            repeat(5) {
                println("Был получен грузовик с грузоподъемностью ${newTruck.maxLoadCapacity}")
                channel.send(newTruck)
                delay(10000)
            }
        }
    }

    suspend fun loadTruck(channel: ReceiveChannel<Truck>) {

        mutex.withLock {
            for (truck in channel) {
                println("Происходит загрузка грузовиков...")
                while (truck.currentWeight < truck.maxLoadCapacity) {
                    for (element in warehouse.products) {
                        println("Со склада получен товар: $element")
                        warehouse.products.receive()
                        truck.currentWeight += element.weight
                    }
                }
            }
        }
    }
}

