package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum()}")
        }
        println("Completed in $time ms")
    }
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { suspendFun1() }
    val two = async { suspendFun2() }
    one.await() + two.await()
}

private suspend fun suspendFun1(): Int {
    delay(1000)
    println("suspend fun 1")
    return 2
}

private suspend fun suspendFun2(): Int {
    delay(1000)
    println("suspend fun 2")
    return 4
}


