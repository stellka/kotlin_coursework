import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlin.random.Random

/*Порт разгрузки — порт распределительного центра, куда поступают пришедшие
на разгрузку грузовики и в котором осуществляется разгрузка грузовика.*/

class DischargePort {

    val result = when (Random.nextInt(1, 4)) {
        1 -> SmallSizedTruck()
        2 -> FoodTruck()
        3 -> MediumTruck()
        4 -> LargeSizedTruck()
        else -> null
    }

    fun getTruck() = runBlocking {
        repeat(3) {
            val result = when (Random.nextInt(1, 4)) {
                1 -> SmallSizedTruck()
                2 -> FoodTruck()
                3 -> MediumTruck()
                4 -> LargeSizedTruck()
                else -> null
            }
            if (result != null) {
                println("Максимальная грузоподъемность пришедшего на разгрузку грузовика: ")
                println(result.maxLoadCapacity)
                println("Происходит выгрузка товаров на склад...")
                result.generateTruck()
                result.unload()
                delay(100000)
            }
        }
        coroutineContext.cancelChildren()
    }

    private fun CoroutineScope.produceTruck() = produce<Truck> {
        while (true) {
            result?.let { send(it) }
        }
    }

    fun CoroutineScope.unloadTruck(result: ReceiveChannel<Truck>): ReceiveChannel<Truck> = produce {
        for (x in produceTruck()) send(result.receive())
    }
}