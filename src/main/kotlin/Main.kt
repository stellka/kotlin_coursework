import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    start()
}

fun start() = runBlocking {
    LoadingPort().getElement()
    DischargePort().unloadTruck()
}

//загрузка грузовиков
//fun start() = runBlocking{
//    val time = measureTimeMillis {
//        async { doSomethingUsefulOne() }
//        async { doSomethingUsefulTwo() }
//        async { doSomethingUsefulThree() }
//    }
//    println("Completed in $time ms")
//}
//
//suspend fun doSomethingUsefulOne() {
//    val loadingPort = LoadingPort()
//    val getElement = loadingPort.getElement()
//    println(getElement)
//}
//
//suspend fun doSomethingUsefulTwo(){
//    val loadingPort = LoadingPort()
//    val getElement = loadingPort.getElement()
//    println(getElement)
//}
//
//suspend fun doSomethingUsefulThree(){
//    val loadingPort = LoadingPort()
//    val getElement = loadingPort.getElement()
//    println(getElement)
//}
