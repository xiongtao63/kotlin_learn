package com.example.learn_kotlin
//高阶函数，会有函数类型的参数，加上 inline 就对了
fun main() {


    println("defaultStrings = $defaultStrings")
//    println("customStrings = $customStrings")
}
val defaultStrings = listOf(1, 2, 3).strings()
inline fun <E> Iterable<E>.strings(transform: (E) -> String = { it.toString() }) = map { transform(it) }