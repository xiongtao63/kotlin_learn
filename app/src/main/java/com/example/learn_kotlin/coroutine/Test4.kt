package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.*

fun main() {
//    dispatchTest()
    testDispatcher()
}
fun dispatchTest(){
    runBlocking {
        launch {
            printlns("in main thread")
        }
        launch(Dispatchers.Unconfined){
            printlns("in Unconfined thread 1")
        }
        launch(Dispatchers.Default){
            printlns(" in child thread 2")
        }
        launch(Dispatchers.IO){
            printlns(" in IO thread")
        }
        launch(newSingleThreadContext("child thread 3")){

            printlns("in new thread")
        }
        launch(newCoroutineContext(this.coroutineContext)){
            printlns("in newCoroutineContext")
        }
        launch(newFixedThreadPoolContext(2,"dd")){
            printlns("in newFixedThreadPoolContext")
        }
    }
}

fun testDispatcher() = runBlocking {
    launch(Dispatchers.Unconfined) {
        printlns("start coroutine")
        delay(500)
        printlns("after delay")
    }

    launch {
        printlns("in main start coroutine ")
        delay(1000)
        printlns("in main after delay")
    }

}