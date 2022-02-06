import kotlinx.coroutines.runBlocking

class DistributionCenter {
    val warehouse = Warehouse()
    val dischargePort = DischargePort()
    val loadingPort = LoadingPort()

    fun start() = runBlocking {
        dischargePort.unloadTruck()
        loadingPort.getElement()

    }

}