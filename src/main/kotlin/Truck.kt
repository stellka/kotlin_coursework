interface Truck {
    val item: Any?
    var timeOfDischarge: Int
    val maxLoadCapacity: Int
    val baggage: MutableList<Product>
    fun addMass(): Product
    fun generateTruck()
}