package trucks

import products.Product

interface Truck {
    val maxLoadCapacity: Int
    val baggage: MutableList<Product>
    var timeOfDischarge: Int
    var currentWeight : Int
}