import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.processNextEventInCurrentThread
import kotlin.random.Random

open class Warehouse {

    var products = Channel<Product>()

}
