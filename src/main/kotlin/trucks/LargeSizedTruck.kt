package trucks

import products.Product

class LargeSizedTruck : Truck {
    override val maxLoadCapacity: Int = 200
    override var baggage = mutableListOf<Product>()
    override var timeOfDischarge = 0
    override var currentWeight = 0
}