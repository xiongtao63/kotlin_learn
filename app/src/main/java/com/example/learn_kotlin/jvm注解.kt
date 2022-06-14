//interface Foo {
//    companion object {
//        @JvmField
//        val answer: Int = 42
//
//        @JvmStatic
//        fun sayHello() {
//            println("Hello, world!")
//        }
//    }
//}

annotation class Foo {
    enum class Direction { UP, DOWN, LEFT, RIGHT }
    annotation class Bar
    companion object {
        fun foo(): Int = 42
        val bar: Int = 42
    }
}

fun main() {
//    @Foo
//    fun (string:String) {
//        println(string)
//    }
    val name = Name("dddd")
    println("${name.s}")
}

inline class Name(val s: String)