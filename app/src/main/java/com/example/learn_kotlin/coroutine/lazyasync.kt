package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            println("===")
            val arg1 = async(start = CoroutineStart.LAZY) { suspendFun1() }
            println("111")
            val arg2 = async(start = CoroutineStart.LAZY) { suspendFun2() }
            delay(1000)
            println("3-------delay")
            arg1.start()
            arg2.start()
            println("suspend finish arg1:${arg1.await()}  arg2:${arg2.await()}  result:${arg1.await() + arg2.await()}")
        }
        println("Completed in $time ms")
    }
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


