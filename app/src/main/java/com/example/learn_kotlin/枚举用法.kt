








//泛型枚举值访问
fun main() {
    printAllValues<RGB>()
}

enum class RGB{
    RED,BLUE,GREEN
}
inline fun <reified T: Enum<T>> printAllValues(){
    println(enumValues<T>().joinToString { it.name })
}