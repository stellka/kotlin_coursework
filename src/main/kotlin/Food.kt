import kotlin.random.Random

enum class Food(override val weight: Int, override val time: Int) : Product{
    BREAD(Random.nextInt(0,10), Random.nextInt(0,10)),
    MILK(Random.nextInt(0,10), Random.nextInt(0,10)),
    POTATOES(Random.nextInt(0,10), Random.nextInt(0,10))
}