import kotlinx.coroutines.processNextEventInCurrentThread
import kotlin.random.Random

open class Warehouse {

    open val bread = mutableListOf<Product>()
    open val milk = mutableListOf<Product>()
    open val potatoes = mutableListOf<Product>()

    open val candles = mutableListOf<Product>()
    open val jewelry = mutableListOf<Product>()
    open val paper = mutableListOf<Product>()

    open val gyroskuter = mutableListOf<Product>()
    open val byke = mutableListOf<Product>()

    open val furniture = mutableListOf<Product>()
    open val wood = mutableListOf<Product>()

}
