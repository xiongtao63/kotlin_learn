package com.example.learn_kotlin

import java.io.File

fun main() {

    val file = File("dddddd").takeIf {
        it.exists()
    } ?: false
    println(file)

    val input = "kotlin"
    val keyword = "in"
    val index = input.indexOf(keyword).takeIf { it>0 }?: error("keyword is not fund")
    println("'$keyword' was found in '$input'")
    println(input)
    println(" ".repeat(index)+"^")

    //takeUnless 与 takeIf 相同，只是它采用了反向谓词。当它 不 满足谓词时返回接收者，否则返回 null
    val index1 = input.indexOf(keyword).takeUnless { it<0 }?: error("keyword is not fund")
    println("'$keyword' was found in '$input'")
    println(input)
    println(" ".repeat(index1)+"^")

    testTakeUnless("")
    testTakeUnless("abc")



}
fun testTakeUnless(string: String){
//    //可调用的引用而不是 lambda 时
//    val result = string.takeUnless {  }
//    println("string = \"$string\"; result = \"$result\"")
}


