import kotlin.random.Random

enum class SmallSizedProduct(override val weight: Int, override val time: Int):Product {

    JEWELRY (Random.nextInt(1,30), Random.nextInt(1,10)),
    PAPER(Random.nextInt(1,30), Random.nextInt(1,10)),
    CANDLES(Random.nextInt(1,30), Random.nextInt(1,10))
}