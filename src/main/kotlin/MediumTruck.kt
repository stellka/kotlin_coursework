import kotlin.random.Random

class MediumTruck : Truck {
    override val maxLoadCapacity: Int = 100
    override var baggage = mutableListOf<Product>()
    override var warehouse = Warehouse()
    var currentWeight = 0

    val furniture = LargeSizedProduct.FURNITURE
    val gyroskuter = MediumSizedProduct.GYROSKUTER
    val byke = MediumSizedProduct.BYKE
    val jewelry = SmallSizedProduct.JEWELRY
    val candles = SmallSizedProduct.CANDLES
    val paper = SmallSizedProduct.PAPER
    val wood = LargeSizedProduct.WOOD

    fun addMass(elem: Product) {
        println(elem)
        baggage.add(elem)
        currentWeight += elem.weight

    }

    override fun load(element: Product) {
        var counter = 0
        val baggage = mutableListOf<Product>()
        while (currentWeight < maxLoadCapacity) {
            if (element == furniture) {
                for (item in Warehouse().furniture) {
                    addMass(element)
                    Warehouse().furniture.remove(item)
                    print("FURNITURE")
                    counter ++
                }
            }
            counter = 0
            if (element == wood && currentWeight < maxLoadCapacity) {
                for (item in Warehouse().wood) {
                    addMass(element)
                    Warehouse().wood.remove(item)
                    println("WOOD")
                    counter ++
                }
            }
            counter = 0
            if (element == gyroskuter && currentWeight < maxLoadCapacity) {
                for (item in Warehouse().gyroskuter) {
                    addMass(element)
                    Warehouse().gyroskuter.remove(element)
                    println("GYROSKUTER")
                    counter ++
                }

            }
            counter = 0
            if (element == byke && currentWeight < maxLoadCapacity) {
                for (item in Warehouse().byke) {
                    addMass(element)
                    Warehouse().byke.remove(element)
                    println("BYKE")
                    counter ++
                }
            }
            counter = 0
            if (element == jewelry && currentWeight < maxLoadCapacity) {
                for (item in Warehouse().jewelry) {
                    addMass(element)
                    Warehouse().jewelry.remove(element)
                    println("JEWELRY")
                    counter ++
                }
            }
            counter = 0
            if (element == candles && currentWeight < maxLoadCapacity) {
                for (item in Warehouse().candles) {
                    addMass(element)
                    Warehouse().candles.remove(element)
                    println("CANDLES")
                    counter ++
                }
            }
            counter = 0
            if (element == paper && currentWeight < maxLoadCapacity) {
                for (item in Warehouse().paper) {
                    addMass(element)
                    Warehouse().paper.remove(element)
                    println("PAPER")
                    counter ++
                }
            }
        }
    }


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
                    println("gyroskuter")
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

    override fun generateTruck(){
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