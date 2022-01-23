import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val dischargePort = DischargePort()
    dischargePort.getTruck()//происходит разгрузка и выводится информация о поступившем на склад товаре
    start()
}

//загрузка грузовиков
fun start() = runBlocking{
    val time = measureTimeMillis {
        async { doSomethingUsefulOne() }
        async { doSomethingUsefulTwo() }
        async { doSomethingUsefulThree() }
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne() {
    val loadingPort = LoadingPort()
    val getElement = loadingPort.getElement()
    println(getElement)
}

suspend fun doSomethingUsefulTwo(){
    val loadingPort = LoadingPort()
    val getElement = loadingPort.getElement()
    println(getElement)
}

suspend fun doSomethingUsefulThree(){
    val loadingPort = LoadingPort()
    val getElement = loadingPort.getElement()
    println(getElement)
}