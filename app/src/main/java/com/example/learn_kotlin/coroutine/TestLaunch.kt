package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext


suspend fun main(args: Array<String>) {
    println("Start")

    // Start a coroutine
    val job = GlobalScope.launch {
        delay(1000)
        println("Hello")
    }
    job.join()
//    Thread.sleep(2000) // wait for 2 seconds
    println("Stop")

    GlobalScope.async {
        delay(3000)
        println("Hello11")
    }

    println("11")

    GlobalScope.async(Dispatchers.Main) {
        withContext(coroutineContext) {
            delay(3000)
        }
    }

    GlobalScope.launch(CommonPool) {
        delay(1000)
        printlns("World!")
    }
    printlns("hello!")
    Thread.sleep(2000)


}

open class DispatcherContext(private val dispatcher: CoroutineDispatcher = Dispatchers.Default)
    : AbstractCoroutineContextElement(ContinuationInterceptor),ContinuationInterceptor{
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return DispatcherContinuation(continuation,dispatcher)
    }

}

class DispatcherContinuation<T>(val continuation: Continuation<T>, val dispatcher: CoroutineDispatcher,) :Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
        dispatcher.dispatch(context){
            continuation.resumeWith(result)
        }
    }

}

