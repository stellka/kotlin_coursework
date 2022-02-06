import kotlin.random.Random

class MediumTruck : Truck {
    override val maxLoadCapacity: Int = 100
    override var baggage = mutableListOf<Product>()
    var currentWeight = 0
    override var timeOfDischarge = 0

    //генерация товра рандомного типа, который в последствии будет загружен в грузовик
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

    //загрузка в грузовик товаров определенного типа
    override fun addMass(): Product {
        if (currentWeight < maxLoadCapacity) {
            baggage.add(item as Product)
            currentWeight += item.weight
        }
        return item as Product
    }

    override fun generateTruck(): MutableList<Product> {
        while (maxLoadCapacity > currentWeight) {
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(LargeSizedProduct.FURNITURE)
                println("FURNITURE")
                currentWeight += LargeSizedProduct.FURNITURE.weight
                timeOfDischarge += LargeSizedProduct.FURNITURE.time

            }
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(MediumSizedProduct.GYROSKUTER)
                println("GYROSKUTER")
                currentWeight += MediumSizedProduct.GYROSKUTER.weight
                timeOfDischarge += MediumSizedProduct.GYROSKUTER.time
            }
            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(MediumSizedProduct.BYKE)
                println("BYKE")
                currentWeight += MediumSizedProduct.BYKE.weight
                timeOfDischarge += MediumSizedProduct.BYKE.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(SmallSizedProduct.JEWELRY)
                println("JEWELRY")
                currentWeight += SmallSizedProduct.JEWELRY.weight
                timeOfDischarge += SmallSizedProduct.JEWELRY.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(SmallSizedProduct.CANDLES)
                println("CANDLES")
                currentWeight += SmallSizedProduct.CANDLES.weight
                timeOfDischarge += SmallSizedProduct.CANDLES.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(SmallSizedProduct.PAPER)
                println("PAPER")
                currentWeight += SmallSizedProduct.PAPER.weight
                timeOfDischarge += SmallSizedProduct.PAPER.time
            }

            for (i in 0..Random.nextInt(0, 10)) {
                baggage.add(LargeSizedProduct.WOOD)
                println("WOOD")
                currentWeight += LargeSizedProduct.WOOD.weight
                timeOfDischarge += LargeSizedProduct.WOOD.time
            }
        }
        return baggage
    }
}