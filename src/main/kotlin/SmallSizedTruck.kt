import kotlin.random.Random

class SmallSizedTruck : Truck {
    override val maxLoadCapacity: Int = 50
    override var timeOfDischarge = 0
    var currentWeight = 0

    override val baggage = mutableListOf<Product>()

    override var warehouse = Warehouse()

    val furniture = LargeSizedProduct.FURNITURE
    val gyroskuter = MediumSizedProduct.GYROSKUTER
    val byke = MediumSizedProduct.BYKE
    val jewelry = SmallSizedProduct.JEWELRY
    val candles = SmallSizedProduct.CANDLES
    val paper = SmallSizedProduct.PAPER
    val wood = LargeSizedProduct.WOOD

    //зарузить товар
    override fun addMass(elem: Product): MutableList<Product> {
        while (currentWeight < maxLoadCapacity) {
            baggage.add(elem)
            currentWeight += elem.weight
        }
        return baggage
    }


    //сгенерировать товары для грузовика
    override fun generateTruck() {
        while (maxLoadCapacity > currentWeight) {
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(furniture)
                currentWeight += furniture.weight
                timeOfDischarge += furniture.time

            }
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(gyroskuter)
                currentWeight += gyroskuter.weight
                timeOfDischarge += gyroskuter.time
            }
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(byke)
                currentWeight += byke.weight
                timeOfDischarge += byke.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(jewelry)
                currentWeight += jewelry.weight
                timeOfDischarge += jewelry.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(candles)
                currentWeight += candles.weight
                timeOfDischarge += candles.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(paper)
                currentWeight += paper.weight
                timeOfDischarge += paper.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(wood)
                currentWeight += wood.weight
                timeOfDischarge += wood.time
            }
        }
    }
}