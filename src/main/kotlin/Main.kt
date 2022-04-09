import food.Warehouse
import ports.DischargePort
import ports.DistributionCenter
import ports.LoadingPort
import trucks.TruckGenerator

fun main() {

    val generator = TruckGenerator()
    val warehouse = Warehouse()
    val loadingPort = LoadingPort(generator, warehouse)
    val unloadingPort = DischargePort(generator, warehouse)
    val distributionCenter = DistributionCenter(loadingPort, unloadingPort)

    distributionCenter.dischageTruck()
    distributionCenter.loadTruck()
}


