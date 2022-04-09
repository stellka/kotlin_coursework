package trucks

import food.Food
import products.LargeSizedProduct
import products.MediumSizedProduct
import products.Product
import products.SmallSizedProduct
import kotlin.random.Random

class TruckGenerator {

    val randomTruck = when (Random.nextInt(1, 4)) {
        1 -> SmallSizedTruck()
        2 -> FoodTruck()
        3 -> MediumTruck()
        else -> LargeSizedTruck()
    }

    fun generateTruck(randomTruck: Truck) : MutableList<Product>{

        while (randomTruck.maxLoadCapacity > randomTruck.currentWeight) {
            val item: Any = when (Random.nextInt(1, 9)) {
                1 -> Food.BREAD
                2 -> MediumSizedProduct.BYKE
                3 -> SmallSizedProduct.JEWELRY
                4 -> Food.MILK
                5 -> Food.POTATOES
                6 -> SmallSizedProduct.CANDLES
                7 -> SmallSizedProduct.PAPER
                8 -> MediumSizedProduct.GYROSKUTER
                9 -> LargeSizedProduct.FURNITURE
                else -> LargeSizedProduct.WOOD
            }

            if (randomTruck is FoodTruck && item == Food.MILK || item == Food.POTATOES || item == Food.BREAD) {
                randomTruck.baggage.add(item as Product)
                println(item)
                randomTruck.currentWeight += item.weight
                randomTruck.timeOfDischarge += item.time
            } else {
                randomTruck.baggage.add(item as Product)
                println(item)
                randomTruck.currentWeight += item.weight
                randomTruck.timeOfDischarge += item.time
            }
        }
        return randomTruck.baggage
    }
}
