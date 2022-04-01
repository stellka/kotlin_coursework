import kotlin.random.Random

class SmallSizedTruck : Truck {
    override val maxLoadCapacity: Int = 50
    override val baggage = mutableListOf<Product>()
    override var timeOfDischarge = 0
    override var currentWeight = 0
}