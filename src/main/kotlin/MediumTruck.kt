import kotlin.random.Random

class MediumTruck : Truck {
    override val maxLoadCapacity: Int = 100
    override var baggage = mutableListOf<Product>()
    override var timeOfDischarge = 0
    override var currentWeight = 0
}