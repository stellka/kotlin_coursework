interface Truck {
    var timeOfDischarge: Int
    var warehouse: Warehouse
    val maxLoadCapacity: Int
    val baggage: MutableList<Product>
    fun addMass(elem: Product): MutableList<Product>
    fun generateTruck()
}