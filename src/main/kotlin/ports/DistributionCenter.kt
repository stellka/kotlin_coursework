package ports

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import trucks.Truck

class DistributionCenter(private val loadingPort: LoadingPort, private val dischargePort: DischargePort) {

    private val channelForTruck = Channel<Truck>()

    @JvmName("launchProcessor1")
    suspend fun launchProcessor(channel: ReceiveChannel<Truck>) {
        for (truck in channel) {
            channel.receive()
        }
    }

    fun dischageTruck() = runBlocking {

        launch { dischargePort.sendTruck(channelForTruck) }
        launch { dischargePort.unloadTruck(channelForTruck) }
        launch { launchProcessor(channelForTruck) }
    }


//    suspend fun launchProcessor(channel: ReceiveChannel<products.Product>) {
//        for (product in channel) {
//            channel.receive()
//        }
//    }
//}

    fun loadTruck() = runBlocking {
        launch { loadingPort.getTruck(channelForTruck) }
        launch { loadingPort.loadTruck(channelForTruck) }
        launch { launchProcessor(channelForTruck) }
    }
}