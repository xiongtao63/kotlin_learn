package com.example.learn_kotlin

fun main() {


    println("defaultStrings = $defaultStrings")
//    println("customStrings = $customStrings")
}
val defaultStrings = listOf(1, 2, 3).strings()
inline fun <E> Iterable<E>.strings(transform: (E) -> String = { it.toString() }) = map { transform(it) }