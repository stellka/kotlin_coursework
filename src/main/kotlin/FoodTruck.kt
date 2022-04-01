class FoodTruck : Truck {
    override val maxLoadCapacity: Int = 30
    override val baggage = mutableListOf<Product>()
    override var timeOfDischarge = 0
    override var currentWeight = 0
}