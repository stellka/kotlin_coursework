import kotlin.random.Random

class TruckGenerator {
        val randomTruck = when (Random.nextInt(1, 2)) {
            1 -> SmallSizedTruck()
            2 -> FoodTruck()
            else -> null
        } //выбор рандомного грузовика для загрузки товара

    }
