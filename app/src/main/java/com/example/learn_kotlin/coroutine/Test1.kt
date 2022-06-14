package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking <Unit>{
        val job = launch(CommonPool){
            var nextPrintTime = 0L
            var i = 0
            while (isActive){
                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    println("I'm sleeping ${i++} ...")
                    nextPrintTime = currentTime + 500L
                }

            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        delay(1300L) // delay a bit to see if it was cancelled....
        println("main: Now I can quit.")
    }
}