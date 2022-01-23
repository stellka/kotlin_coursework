import kotlin.random.Random

class SmallSizedTruck : Truck {
    override val maxLoadCapacity: Int = 50

    var currentWeight = 0

    val furniture = LargeSizedProduct.FURNITURE
    val gyroskuter = MediumSizedProduct.GYROSKUTER
    val byke = MediumSizedProduct.BYKE
    val jewelry = SmallSizedProduct.JEWELRY
    val candles = SmallSizedProduct.CANDLES
    val paper = SmallSizedProduct.PAPER
    val wood = LargeSizedProduct.WOOD

    //загрузить грузовик товаром
    override fun load(element: MutableList<Product>?) {
        val baggage = mutableListOf<Product>()
        while (currentWeight < maxLoadCapacity) {

            if (element == warehouse.bread && currentWeight < maxLoadCapacity) {
                baggage.add(furniture)
                currentWeight += furniture.weight
            }

            if (element == warehouse.wood && currentWeight < maxLoadCapacity) {
                val wood = LargeSizedProduct.WOOD
                baggage.add(wood)
                currentWeight += wood.weight
            }

            if (element == warehouse.gyroskuter && currentWeight < maxLoadCapacity) {
                baggage.add(gyroskuter)
                currentWeight += gyroskuter.weight
            }

            if (element == warehouse.byke && currentWeight < maxLoadCapacity) {
                baggage.add(byke)
                currentWeight += byke.weight
            }

            if (element == warehouse.jewelry && currentWeight < maxLoadCapacity) {
                baggage.add(jewelry)
                currentWeight += jewelry.weight
            }

            if (element == warehouse.candles && currentWeight < maxLoadCapacity) {
                baggage.add(candles)
                currentWeight += candles.weight
            }

            if (element == warehouse.paper && currentWeight < maxLoadCapacity) {
                baggage.add(paper)
                currentWeight += paper.weight
            }

            if (element == warehouse.wood && currentWeight < maxLoadCapacity) {
                baggage.add(wood)
                currentWeight += wood.weight
            }
        }
        println(baggage)
    }

    override val baggage = mutableListOf<Product>()

    override var warehouse = Warehouse()

    //разгрузить грузовик
    override fun unload() {
        println("Товары, которые поступают на склад: ")
        var timeOfDischarge =
            candles.time + jewelry.time + paper.time + furniture.time + gyroskuter.time + byke.time + wood.time
        var i = 0
        while (timeOfDischarge > 0) {
            for (element in baggage)
                if (element == candles)
                    i++
            if (candles.weight != 0 && candles in baggage) {
                warehouse.candles.add(candles)
                for (j in 0..i) {
                    timeOfDischarge -= candles.time
                    baggage.remove(candles)
                    println("candles")
                }
            }
            i = 0
            for (element in baggage)
                if (element == jewelry)
                    i++
            if (jewelry.weight != 0 && jewelry in baggage) {
                warehouse.jewelry.add(candles)
                for (j in 0..i) {
                    timeOfDischarge -= jewelry.time
                    baggage.remove(jewelry)
                    println("jewelry")
                }
            }
            i = 0
            for (element in baggage)
                if (element == paper)
                    i++
            if (paper.weight != 0 && paper in baggage) {
                warehouse.paper.add(paper)
                for (j in 0..i) {
                    timeOfDischarge -= paper.time
                    baggage.remove(paper)
                    println("paper")
                }
            }
            i = 0
            for (element in baggage)
                if (element == byke)
                    i++
            if (byke.weight != 0 && byke in baggage) {
                warehouse.byke.add(byke)
                for (j in 0..i) {
                    timeOfDischarge -= byke.time
                    baggage.remove(byke)
                    println("byke")
                }
            }
            i = 0
            for (element in baggage)
                if (element == gyroskuter)
                    i++
            if (gyroskuter.weight != 0 && gyroskuter in baggage) {
                warehouse.gyroskuter.add(gyroskuter)
                for (j in 0..i) {
                    timeOfDischarge -= gyroskuter.time
                    baggage.remove(gyroskuter)
                }
            }
            i = 0
            for (element in baggage)
                if (element == furniture)
                    i++
            if (furniture.weight != 0 && furniture in baggage) {
                warehouse.furniture.add(furniture)
                for (j in 0..i) {
                    timeOfDischarge -= furniture.time
                    baggage.remove(furniture)
                    println("furniture")
                }
            }
            i = 0
            for (element in baggage)
                if (element == wood)
                    i++
            if (wood.weight != 0 && wood in baggage) {
                warehouse.wood.add(wood)
                for (j in 0..i) {
                    timeOfDischarge -= wood.time
                    baggage.remove(wood)
                    println("wood")
                }
            }
        }
    }

    //сгенерировать товары для грузовика
    override fun generateTruck() {


        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(furniture)
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(gyroskuter)
        }
        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(byke)
        }

        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(jewelry)
        }

        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(candles)
        }

        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(paper)
        }

        for (i in 0..Random.nextInt(0, 10)) {
            baggage.add(wood)
        }
    }
}