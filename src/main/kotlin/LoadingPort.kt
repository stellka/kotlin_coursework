import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import kotlin.random.Random

class LoadingPort {

    val randomTruck = DischargePort().result //выбор рандомного грузовика для загрузки товара

    val storage = Warehouse()
    private val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun getElement(): Unit = withContext(scope.coroutineContext) {
        //код по получению элементов
        println("Происходит загрузка товаров в грузовик...")
        val getItem = storage?.item //получить случайный товар из хранилища
        randomTruck?.load(getItem) //положить элемент в грузовик
        storage?.removeItemsFromStorage()//удалить взятый элемент из хранилища
    }
}