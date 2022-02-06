import kotlin.random.Random

class TruckGenerator {
    val randomTruckForDischarge = when (Random.nextInt(1, 4)) {
        1 -> SmallSizedTruck()
        2 -> FoodTruck()
        3 -> MediumTruck()
        4 -> LargeSizedTruck()
        else -> null
    }//выбор рандомного грузовика для разгрузки товара

    val randomTruckForLoading = when (Random.nextInt(1, 2)) {
        1 -> SmallSizedTruck()
        2 -> FoodTruck()
        else -> null
    } //выбор рандомного грузовика для загрузки товара
}
