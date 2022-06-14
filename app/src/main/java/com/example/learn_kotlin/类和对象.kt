package com.example.learn_kotlin



fun main() {
//    testCons()
//   testGetSet()
//    lateinit()
//    testInit()
//    openClass()
//    innerClassTest()
//    testNiMing()
}
abstract class A{}
enum class B{}
final class C{}
open class DD{}
annotation class E{}


fun testNiMing() {
val t = Test()
    t.setInterface(object : TestInterface{
        override fun test() {
            print("dddddddd")
        }

    })

}
class Test{
    var v = "成员属性"
    fun setInterface(test:TestInterface){
        test.test()
    }
}
interface  TestInterface{
    fun test()
}

fun innerClassTest() {
val outer = Outer()
    val foo = outer.Inner().foo()
    println(foo)
    val d = outer.Inner().innerMethod()
    println(d)


}
class Outer{
    private val bar:Int = 2
    var s = "成员属性"
    inner class Inner{
        fun foo() = bar
        fun innerMethod(){
            println(s)
            var o = this@Outer
            println("内部类可以引用外部类的成员，例如：" + o.s)
        }
    }
}

fun openClass() {
val b = Base()


}
 open class Base{
     open fun f(){}
}
abstract class Dev:Base(){
    override fun f() {
        super.f()
    }
}
class D : Base(){
    override fun f() {
        super.f()
    }
}

fun testInit() {
    val roo = Rooboo("lilil",111)
    println(roo.url)
    println(roo.site)
    println(roo.country)
    roo.test()

}
class Per constructor(val string: String){
    constructor(name: String,age:Int):this(name){

    }
}
class Rooboo constructor(name: String){
    var url = "dddddddddddddd"
    var country = "CN"
    var site = name
    init {
        println("初始化$name")
    }
    fun test(){
        print("====")
    }
    constructor(name: String,age: Int):this(name){
        println("年龄$age")
    }

}

lateinit var topVariable:String
fun lateinit() {
    val test = MyTest()
    test.check()
//    print(test::name.isInitialized)
    print(::topVariable.isInitialized)
}
class MyTest{
    lateinit var name: String
    fun isOdd(x: Int) = x % 2 != 0
    fun check(){
        if (this::name.isInitialized){
            print(name)
        }else{
            print("没初始化")
        }

    }

    fun test(){
        var list = listOf(1, 2, 3, 4, 5)
        print(list.filter (this::isOdd))
    }

}

fun testGetSet() {

    val person = Person()
    person.lastName = "lisi"
    println("lastName:${person.lastName}")
    person.no = 6
    println("no:${person.no}")
    person.no = 26
    println("no:${person.no}")
}

fun testCons() {
    val persion = Persion("ddd")
    println(persion.name)

}

class Persion constructor( name:String){
    val name = name
}
class Person{
    var lastName:String = "zhang"
    get() = field.uppercase()
    set
    var no:Int = 100
    get() = field
    set(value) {
        if (value <10){
            field = value
        }else{
            field = -1
        }
    }
    var height:Float = 145.0f
    private set

}