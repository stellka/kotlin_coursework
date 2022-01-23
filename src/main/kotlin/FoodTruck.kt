import kotlin.random.Random

class FoodTruck : Truck {
    override val maxLoadCapacity: Int = 30

    private var currentWeight = 0
    override var warehouse = Warehouse()

    val bread = Food.BREAD
    val milk = Food.MILK
    val potatoes = Food.POTATOES

    override fun load(element: MutableList<Product>?) {
        val baggage = mutableListOf<Product>()
        while (currentWeight < maxLoadCapacity) {

            if (element == warehouse.bread && currentWeight < maxLoadCapacity) {
                baggage.add(bread)
                currentWeight += bread.weight
            }

            if (element == warehouse.milk && currentWeight < maxLoadCapacity) {
                baggage.add(milk)
                currentWeight += milk.weight
            }

            if (element == warehouse.potatoes && currentWeight < maxLoadCapacity) {
                baggage.add(potatoes)
                currentWeight += potatoes.weight
            }
        }
        println(baggage)
    }

    override val baggage = mutableListOf<Product>()

    override fun unload() {
        println("Товары, которые поступают на склад: ")
        var timeOfDischarge = bread.time + milk.time + potatoes.time

        var i = 0
        while (timeOfDischarge > 0) {
            for (element in baggage)
                if (element == bread)
                    i++
            if (bread.weight != 0 && bread in baggage) {
                warehouse.candles.add(bread)
                for (j in 0..i) {
                    timeOfDischarge -= bread.time
                    baggage.remove(bread)
                    println("bread")
                }
            }

            i=0
            for (element in baggage)
                if (element == milk)
                    i++
            if (milk.weight != 0 && milk in baggage) {
                warehouse.milk.add(milk)
                for (j in 0..i) {
                    timeOfDischarge -= milk.time
                    baggage.remove(milk)
                    println("milk")
                }
            }

            i=0
            for (element in baggage)
                if (element == potatoes)
                    i++
            if (potatoes.weight != 0 && potatoes in baggage) {
                warehouse.potatoes.add(potatoes)
                for (j in 0..i) {
                    timeOfDischarge -= potatoes.time
                    baggage.remove(potatoes)
                    println("potatoes")
                }
            }
        }
    }

    override fun generateTruck(){

        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(bread)
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(milk)
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(potatoes)
        }
    }
}