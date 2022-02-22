import kotlin.random.Random

class FoodTruck : Truck {
    override val maxLoadCapacity: Int = 30

    private var currentWeight = 0
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
    override var timeOfDischarge = 0
    val bread = Food.BREAD
    val milk = Food.MILK
    val potatoes = Food.POTATOES

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
            baggage.add(bread)
            currentWeight += bread.weight
            timeOfDischarge += bread.time
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(milk)
            currentWeight += milk.weight
            timeOfDischarge += milk.time
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(potatoes)
            currentWeight += potatoes.weight
            timeOfDischarge += potatoes.time
        }
        return baggage
    }
}