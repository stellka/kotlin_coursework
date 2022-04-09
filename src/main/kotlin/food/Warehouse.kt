package food

import kotlinx.coroutines.channels.Channel
import products.Product

open class Warehouse {

    var products = Channel<Product>()
}
