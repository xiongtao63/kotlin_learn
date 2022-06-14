package com.example.learn_kotlin

import java.util.*
import kotlin.collections.HashSet

fun main() {
    val p = Person1(2, "张三")
    println("isStudent: ${p.isStudent}")

    val list = listOf("a", "b", "c")
    println("list.lastIndex: ${list.lastIndex}")

//    局部委托属性
    val answer by lazy {
        println("Calculating the answer...")
        42
    }
    if (needAnswer()) {
        println("The answer is $answer.") // 此时计算出答案
    } else {
        println("Sometimes no answer is the answer...")
    }
}

data class Person1(val age: Int, val name: String) {
    val isStudent get() = age >= 10
}

//扩展函数，List 的最后下标
public val <T> List<T>.lastIndex: Int
    inline get() = this.size - 1

fun needAnswer() = Random().nextBoolean()

