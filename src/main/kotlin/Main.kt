import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking{
    DistributionCenter().dischageTruck()
    DistributionCenter().loadTruck()
}


