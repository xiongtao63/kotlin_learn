package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    //轻量级
    runBlocking {
//        val jobs = List(100000){
//            launch(CommonPool) {
//                delay(1000)
//                print(".")
//            }
//        }
//        jobs.forEach { it.join() }
//        val jobs = List(10000000){
//            thread {
//                Thread.sleep(1000L)
//                print(".")
//            }
//        }
//        jobs.forEach ( Thread::join )
    }
}