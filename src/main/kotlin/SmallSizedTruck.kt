import kotlin.random.Random

class SmallSizedTruck : Truck {
    override val maxLoadCapacity: Int = 50
    override var timeOfDischarge = 0
    var currentWeight = 0

    override val baggage = mutableListOf<Product>()

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

    //зарузить товар
    override fun addMass(): Product {
        if (currentWeight < maxLoadCapacity) {
            baggage.add(item as Product)
            currentWeight += item.weight
        }
        return item as Product
    }


    //сгенерировать товары для грузовика
    override fun generateTruck() {
        while (maxLoadCapacity > currentWeight) {
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(LargeSizedProduct.FURNITURE)
                currentWeight += LargeSizedProduct.FURNITURE.weight
                timeOfDischarge += LargeSizedProduct.FURNITURE.time

            }
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(MediumSizedProduct.GYROSKUTER)
                currentWeight += MediumSizedProduct.GYROSKUTER.weight
                timeOfDischarge += MediumSizedProduct.GYROSKUTER.time
            }
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(MediumSizedProduct.BYKE)
                currentWeight += MediumSizedProduct.BYKE.weight
                timeOfDischarge += MediumSizedProduct.BYKE.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(SmallSizedProduct.JEWELRY)
                currentWeight += SmallSizedProduct.JEWELRY.weight
                timeOfDischarge += SmallSizedProduct.JEWELRY.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(SmallSizedProduct.CANDLES)
                currentWeight += SmallSizedProduct.CANDLES.weight
                timeOfDischarge += SmallSizedProduct.CANDLES.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(SmallSizedProduct.PAPER)
                currentWeight += SmallSizedProduct.PAPER.weight
                timeOfDischarge += SmallSizedProduct.PAPER.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(LargeSizedProduct.WOOD)
                currentWeight += LargeSizedProduct.WOOD.weight
                timeOfDischarge += LargeSizedProduct.WOOD.time
            }
        }
    }
}