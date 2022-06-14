package com.example.learn_kotlin

import java.lang.IllegalArgumentException

fun main() {
    val a:Int = 10
    println(a === a)
    val boxA:Int? = a
    val boxB:Int? = a
    println(boxA === boxB)
    println(boxA == boxB)

    //类型转换
    val b:Byte = 1
    val i:Int = b.toInt() //toByte()
    val l = 1L +3
    println(l is Long)
    //Kotlin中的 位运算符 只对Int和Long两种 数据类型 起作用！
    var x = (a.toInt() and 0xff)
    println(a.shl(1))
    println(a.shr(1))
    println(a.ushr(1))
    println(a.and(3))
    println(a.or(4))
    println(a.xor(4))
    println(a.inv())
    println(a.inc())

    println(dicimalDigitValue('0'))
    arrayTest()
    stringTest()
}

//字符 单引号 'a'
fun dicimalDigitValue(c:Char):Int{
    if (c !in '0'..'9'){
        throw IllegalArgumentException("out of range")
    }
    return c.toInt() - '0'.toInt()
}
//array
fun arrayTest(){
    var a = arrayOf(1,2,3)
    val b = Array(3,{i -> (i*3)})
    println(a[0])
    println(b[1])
    val x = intArrayOf(2,3,3,3,3,3,3,4)
    x[0] = x[1]*x[2]
    println(x[0])
}

//字符串
fun stringTest(){
    val text = """
            多行
        多行
    """.trimMargin()
    print(text)

    val str:String = "dsfsdf"
    for (i in str){
        print(i+",")
    }

    val s = "hello world"
    println(s.first())
    println(s.last())
    println(s.get(3))
    println(s[3])
    println(s.indexOf("o"))
    println(s.lastIndexOf("o"))
//字符串替换
    var string = "hello world! hello world"
    println(string.replace("world","kotlin"))
    println(string.replaceFirst("world","kotlin"))
    println(string.replaceBefore("world","kotlin"))
    println(string.replaceAfter("world","kotlin"))

//分割和正则支持：split、toRegex
    var ss = "hello.dddd.ssss"
    val split = ss.split(".")
    print(split)
    for (i in split){
        println(i)
    }

    println("hello.kotlin.heima".split("\\.".toRegex()))
    println("hello.kotlin-heima".split(".","-"))

}