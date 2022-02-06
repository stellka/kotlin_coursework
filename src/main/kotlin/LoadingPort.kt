import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.random.Random

class LoadingPort {

    private val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun getElement(): Unit = withContext(scope.coroutineContext) {
        //код по получению элементов
        println("Происходит загрузка товаров в грузовик...")
        repeat(5) {
            val randomTruck = TruckGenerator().randomTruckForLoading
            if (randomTruck?.item == DistributionCenter().warehouse.products.receive()) {
                println("В грузовик был загружен товар")
                println(Warehouse().products.receive())
                randomTruck.addMass()
            }
        }
        coroutineContext.cancelChildren()
    }
}

