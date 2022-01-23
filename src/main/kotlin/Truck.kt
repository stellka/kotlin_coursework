interface Truck {
    var warehouse: Warehouse
    val maxLoadCapacity: Int
    val baggage: MutableList<Product>
    fun unload()
    fun load(element: MutableList<Product>?)
    fun generateTruck()
}