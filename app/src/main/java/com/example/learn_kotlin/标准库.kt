package com.example.learn_kotlin

//字符串到数字的转换
fun main() {
    val string = "1231231"
    println(string.toIntOrNull())
    val i = System.getenv("PORT")?.toIntOrNull() ?: 80
    println(i)

    //onEach()  对集合数据进行操作，
    val array = arrayOf(1,2,3,4,5,6,7)
    array.filter { it> 3 }
        .onEach { println(it) }
        .forEach{
            println("="+it)
        }

    //aslo
    var ss = "test".also {
        println("----")
        1000
    }
    println(ss)
    //apply    also 把调用对象当参数传入, apply是调用对象的方法 所以also能处理的更多
    var s = "1111".apply {
        println(toInt()+100)
        200
    }
    println(s)

    val block = Block().apply {
        content = "contentt"
    }
    val copy = block.copy()
    println(block.content == copy.content)

}
class Block{
    lateinit var content:String
}

fun Block.copy() = Block().also {
    it.content = this.content
}

fun Block.copy1() = Block().apply {
    this.content = this@copy1.content
}