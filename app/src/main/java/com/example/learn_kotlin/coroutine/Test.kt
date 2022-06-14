package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
    runBlocking {
        val time = measureTimeMillis {
            println("===")
            val arg1 = suspendFun1()
            println("111")
            val arg2 = suspendFun2()
            println("suspend finish arg1:$arg1  arg2:$arg2  result:${arg1 + arg2}")
        }
        println("Completed in $time ms")
    }
}

private suspend fun suspendFun1(): Int{
    delay(1000)
    println("suspend fun 1")
    return 2
}
private suspend fun suspendFun2(): Int{
    delay(1000)
    println("suspend fun 2")
    return 4
}


