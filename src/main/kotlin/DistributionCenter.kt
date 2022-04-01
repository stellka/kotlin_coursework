import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DistributionCenter {
    val warehouse = Warehouse()
    private val channelForTruck = Channel<Truck>()

    @JvmName("launchProcessor1")
    suspend fun launchProcessor(channel: ReceiveChannel<Truck>) {
        for (truck in channel) {
            channel.receive()
        }
    }

    fun dischageTruck() = runBlocking {
        launch { DischargePort().sendTruck(channelForTruck) }
        launch { DischargePort().unloadTruck(channelForTruck) }
        launch { launchProcessor(channelForTruck) }
    }


//    suspend fun launchProcessor(channel: ReceiveChannel<Product>) {
//        for (product in channel) {
//            channel.receive()
//        }
//    }
//}

    fun loadTruck() = runBlocking {
        launch { LoadingPort().getTruck(channelForTruck) }
        launch { LoadingPort().loadTruck(channelForTruck) }
        launch { launchProcessor(channelForTruck) }
    }
}