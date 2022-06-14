package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.lang.Exception
import java.util.concurrent.CancellationException

fun main() {
//    runBlocking<Unit> {
//        launch(CommonPool) {
//            delay(1000L)
//            println("World!")
//        }
//        println("Hello,")
//        delay(2000L)
//
//    }
//
//    runBlocking<Unit> {
//        runBlocking {
//            delay(1000L)
//            println("World!")
//        }
//        println("Hello,")
//    }

    runBlocking<Unit> {
        val job = launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
//        job.cancel()
//        job.cancel(Exception())
//        job.cancel(CancellationException("ddd"))
    }
//    val table : FileTable<String>
//    val m: Method
//    m.invoke()

}

typealias FileTable<T> = MutableMap<T,MutableList<File>>
typealias Method = ()->Unit

