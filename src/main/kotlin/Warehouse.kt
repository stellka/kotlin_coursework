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

    val item = when (Random.nextInt(1, 10)) {
        1 -> bread
        2 -> byke
        3 -> jewelry
        4 -> milk
        5 -> potatoes
        6 -> candles
        7 -> paper
        8 -> gyroskuter
        9 -> furniture
        10 -> wood

        else -> {
            null
        }
    }

    fun removeItemsFromStorage(){
        println("Товары, которые извлекаются со склада: ")
        if (item == bread){
            for (element in bread) {
                bread.remove(element)
                println("bread")
            }
        }

        if (item == byke){
            for (element in byke) {
                byke.remove(element)
                println("byke")
            }
        }

        if (item == jewelry){
            for (element in jewelry) {
                jewelry.remove(element)
                println("jewelry")
            }
        }

        if (item == milk){
            for (element in milk) {
                milk.remove(element)
                println("milk")
            }
        }

        if (item == potatoes){
            for (element in potatoes) {
                potatoes.remove(element)
                println("potatoes")
            }
        }

        if (item == candles){
            for (element in candles) {
                candles.remove(element)
                println("candles")
            }
        }

        if (item == paper){
            for (element in paper) {
                paper.remove(element)
                println("paper")
            }
        }

        if (item == gyroskuter){
            for (element in gyroskuter) {
                gyroskuter.remove(element)
                println("gyroskuter")
            }
        }

        if (item == furniture){
            for (element in furniture) {
                furniture.remove(element)
                println("furniture")
            }
        }

        if (item == wood){
            for (element in wood) {
                wood.remove(element)
                println("wood")
            }
        }
    }
}
