import kotlin.random.Random

class FoodTruck : Truck {
    override val maxLoadCapacity: Int = 30

    private var currentWeight = 0
    override var warehouse = Warehouse()

    override var timeOfDischarge = 0
    val bread = Food.BREAD
    val milk = Food.MILK
    val potatoes = Food.POTATOES

    override val baggage = mutableListOf<Product>()

    override fun addMass(elem: Product): MutableList<Product> {
        while (currentWeight < maxLoadCapacity) {
            baggage.add(elem)
            currentWeight += elem.weight
        }
        return baggage
    }


    override fun generateTruck(){

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
    }
}