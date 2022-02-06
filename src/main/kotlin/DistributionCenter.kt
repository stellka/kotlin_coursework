import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DistributionCenter {
    val warehouse = Warehouse()
    private val truckGenerator = TruckGenerator()
    private val dischargePort = DischargePort()
    val loadingPort = LoadingPort()
    private val channelForTruck = Channel<Truck>()

    fun generation() = runBlocking {
        launch { truckGenerator.sendTruck(channelForTruck) }
        launch { truckGenerator.launchProcessor(channelForTruck) }
    }

    fun discharging() = runBlocking{
        launch { dischargePort.unloadTruck(channelForTruck) }
        launch { dischargePort.launchProcessor(warehouse.products) }
    }
}