import kotlin.random.Random

class FoodTruck : Truck {
    override val maxLoadCapacity: Int = 30

    var currentWeight = 0

    override var timeOfDischarge = 0

    override val item: Any? = when (Random.nextInt(1, 10)) {
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

    override val baggage = mutableListOf<Product>()

    override fun addMass(): Product {
        if (currentWeight < maxLoadCapacity) {
            baggage.add(item as Product)
            currentWeight += item.weight
        }
        return item as Product
    }

    override fun generateTruck() : MutableList<Product>{

        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(Food.BREAD)
            println("BREAD")
            currentWeight += Food.BREAD.weight
            timeOfDischarge += Food.BREAD.time
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(Food.MILK)
            println("MILK")
            currentWeight += Food.MILK.weight
            timeOfDischarge += Food.MILK.time
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(Food.POTATOES)
            println("POTATOES")
            currentWeight +=Food.POTATOES.weight
            timeOfDischarge += Food.POTATOES.time
        }
        return baggage
    }
}