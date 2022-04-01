import kotlinx.coroutines.channels.Channel

open class Warehouse {

    var products = Channel<Product>()
}
