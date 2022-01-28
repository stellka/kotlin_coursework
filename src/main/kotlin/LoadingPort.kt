import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import kotlin.random.Random

class LoadingPort {

    private val scope = CoroutineScope(newSingleThreadContext("storage"))

    suspend fun getElement(): Unit = withContext(scope.coroutineContext) {
        //код по получению элементов
        var randomItem = when (Random.nextInt(1, 10)) {
            1 -> Food.BREAD
            2 -> MediumSizedProduct.BYKE
            3 -> SmallSizedProduct.JEWELRY
            4 -> Food.MILK
            5 -> Food.POTATOES
            6 -> SmallSizedProduct.CANDLES
            7 -> SmallSizedProduct.PAPER
            8 -> MediumSizedProduct.GYROSKUTER
            9 -> LargeSizedProduct.FURNITURE
            10 -> LargeSizedProduct.WOOD

            else -> {
                null
            }
        }
        println(randomItem)

        val randomTruck = when (Random.nextInt(1, 4)) {
            1 -> SmallSizedTruck()
            2 -> FoodTruck()
            3 -> MediumTruck()
            4 -> LargeSizedTruck()
            else -> null
        } //выбор рандомного грузовика для загрузки товара

        println("Происходит загрузка товаров в грузовик...")
        if (randomItem != null) {
            randomTruck?.load(randomItem)
            println(randomItem.let { randomTruck?.load(it) })
            println(randomTruck!!.baggage)
        }else {
            randomItem = when (Random.nextInt(1, 10)) {
                1 -> Food.BREAD
                2 -> MediumSizedProduct.BYKE
                3 -> SmallSizedProduct.JEWELRY
                4 -> Food.MILK
                5 -> Food.POTATOES
                6 -> SmallSizedProduct.CANDLES
                7 -> SmallSizedProduct.PAPER
                8 -> MediumSizedProduct.GYROSKUTER
                9 -> LargeSizedProduct.FURNITURE
                10 -> LargeSizedProduct.WOOD

                else -> {
                    null
                }
            }
            println(randomItem?.let { randomTruck?.load(it) })
            println(randomTruck!!.baggage)
        }

    } //положить элемент в грузовик и удалить со склада
}

//            if (randomItem in Warehouse().milk || randomItem in Warehouse().bread || randomItem in Warehouse().potatoes ||
//                randomItem in Warehouse().paper || randomItem in Warehouse().jewelry || randomItem in Warehouse().gyroskuter
//                || randomItem in Warehouse().furniture || randomItem in Warehouse().wood || randomItem in Warehouse().candles
//                || randomItem in Warehouse().byke
//            ) {
//randomTruck?.load(randomItem)
//println(randomTruck!!.baggage)
//println(randomItem?.let { randomTruck.load(it) })
//println(randomItem)
////            } else {
//                randomItem = when (Random.nextInt(1, 10)) {
//                    1 -> Food.BREAD
//                    2 -> MediumSizedProduct.BYKE
//                    3 -> SmallSizedProduct.JEWELRY
//                    4 -> Food.MILK
//                    5 -> Food.POTATOES
//                    6 -> SmallSizedProduct.CANDLES
//                    7 -> SmallSizedProduct.PAPER
//                    8 -> MediumSizedProduct.GYROSKUTER
//                    9 -> LargeSizedProduct.FURNITURE
//                    10 -> LargeSizedProduct.WOOD
//
//                    else -> {
//                        null
//                    }
//                }
//                randomTruck?.load(randomItem!!)
//                println(randomItem)
//                println(randomItem?.let { randomTruck?.load(it) })
//            }
//} //положить элемент в грузовик и удалить со склада
//}