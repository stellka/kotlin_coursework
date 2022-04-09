package products

import kotlin.random.Random

enum class MediumSizedProduct(override val weight: Int, override val time: Int): Product {
    GYROSKUTER(Random.nextInt(30,50), Random.nextInt(10,20)),
    BYKE(Random.nextInt(30,50), Random.nextInt(10,20))
}