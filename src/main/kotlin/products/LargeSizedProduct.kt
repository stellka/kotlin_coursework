package products

import kotlin.random.Random

enum class LargeSizedProduct(override val weight: Int, override val time: Int) : Product {
    FURNITURE(Random.nextInt(50,100), Random.nextInt(30,50)),
    WOOD(Random.nextInt(50,100), Random.nextInt(30,50))
}