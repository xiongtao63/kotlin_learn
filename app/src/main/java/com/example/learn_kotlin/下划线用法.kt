package com.example.learn_kotlin

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    //使用 _ 字符替换不使用的参数的名称
    val map = mapOf(1 to "one", 2 to "two")
    map.forEach { (_, u) -> println("$u") }
    map.forEach { (_, _) -> println("dd") }

    //解构声明：
    //数据类自带解构方法
    val (_, status) = getResult()
    println("status is $status")
    val result = getResult()
    println("status is ${result.status}")

    //数字字面值中的下划线
    val oneMillion = 1_000_000
    val hexByte = 0xFF_AA_BB_CC
    val byte = 0b10000100_00010001_00011000_10101010
    println(oneMillion)
    println(hexByte.toString(16))
    println(byte.toString(2))



}
data class Result(val value: Any, val status: String)
//also 返回传入的对象，let 返回最后一行，没有则返回Unit
fun getResult() = Result(42,"ok").also { println("getResult() returns $it") }


