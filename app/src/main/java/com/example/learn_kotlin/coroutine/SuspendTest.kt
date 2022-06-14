package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.suspendCoroutine

fun main() {
    CoroutineScope(EmptyCoroutineContext).launch {
        val arg1 = suspendFun1()
        val arg2 = suspendFun2()
        println("suspend finish arg1:$arg1  arg2:$arg2  result:${arg1 + arg2}")
    }
//    GlobalScope.launch{
//
//    }
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

