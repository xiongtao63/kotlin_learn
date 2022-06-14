package com.example.learn_kotlin.coroutine

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.Exception
import java.util.concurrent.*
import kotlin.coroutines.*

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    val executor = Executors.newSingleThreadScheduledExecutor() {
        Thread(it, "scheduler")
    }
    printlns("before coroutine")
    val context = FilePath("a.txt")+CommonPool
    launchWithContext(context){
        printlns("in coroutine. Before suspend.")
        val result = calcMd51(this[FilePath]!!.path).await()
        printlns("in coroutine. After suspend. result = $result")
    }
    /*launch1(FilePath("a.txt")+CommonPool) {
        printlns("in coroutine. Before suspend.")
        val result: String = suspendCoroutine { continuation ->
            printlns("in suspend block.")
            continuation.resume(calcMd5(continuation.context[FilePath]!!.path))
            printlns("after resume.")
//            executor.submit {
//                continuation.resume(calcMd5(continuation.context[FilePath]!!.path))
//                printlns("after resume.")
//            }
        }
        printlns("in coroutine. After suspend. result = $result")
//        executor.shutdown()
    }*/
    printlns("after coroutine")
    CommonPool.pool.awaitTermination(10000,TimeUnit.MILLISECONDS)
}

fun asyncCalMd5(path: String, block: suspend () -> Unit) {
    val continuation = object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = FilePath(path)+CommonPool

        override fun resumeWith(result: Result<Unit>) {
            printlns("resutl: ${result}")
        }


    }
    block.startCoroutine(continuation)
}

class FilePath(val path: String) : AbstractCoroutineContextElement(FilePath) {
    companion object Key : CoroutineContext.Key<FilePath>
}

fun calcMd5(path: String): String {
    printlns("calc md5 for $path.")
    Thread.sleep(2000)
    return System.currentTimeMillis().toString()

}

@RequiresApi(Build.VERSION_CODES.N)
fun calcMd51(path: String): CompletableFuture<String>{
    return CompletableFuture.supplyAsync {
        printlns("calc md5 for $path.")
        Thread.sleep(2000)
        System.currentTimeMillis().toString()
    }
}

fun printlns(message: String) {
    println(Thread.currentThread().name + "===" + message)

}

//实现了AbstractCoroutineContextElement 就是上下文 ，存储数据，在上下文里面加拦截器
// 传入原始的continuation,返回新传continuation
open class Pool(val pool:ForkJoinPool): AbstractCoroutineContextElement(ContinuationInterceptor),ContinuationInterceptor{
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return PoolContinuation(pool,continuation.context.fold(continuation,{
            cont,element ->
            if(element != this@Pool && element is ContinuationInterceptor)
                element.interceptContinuation(continuation) else cont
        }))
    }

}
//新的continuation
private class PoolContinuation<T>(val pool: ForkJoinPool,val continuation: Continuation<T>)
    :Continuation<T> by continuation{
    override fun resumeWith(result: Result<T>) {
        printlns("result.isSuccess=== ${result.isSuccess}.")
        if(result.isSuccess){
            if(isPoolThread())continuation.resume(result.getOrNull()!!)
            else pool.execute{continuation.resume(result.getOrNull()!!)}
        } else {
            if(isPoolThread())continuation.resumeWithException(Exception("失败"))
            else pool.execute{continuation.resumeWithException(Exception("失败"))}
        }
    }

    fun isPoolThread(): Boolean = (Thread.currentThread() as? ForkJoinWorkerThread)?.pool == pool

}

//@RequiresApi(Build.VERSION_CODES.N)
object CommonPool : Pool(ForkJoinPool())


class StandloneCoroutine(override val context: CoroutineContext) : Continuation<Unit>{
    override fun resumeWith(result: Result<Unit>) {
        if(result.isSuccess){
        }else{
        }
    }

}
fun<T> launch1(
    receiver:T,
    context: CoroutineContext,
           block: suspend T.() -> Unit){
    block.startCoroutine(receiver,StandloneCoroutine(context))
}

fun launchWithContext(context: CoroutineContext,block: suspend CoroutineContext.() -> Unit){
    launch1(context,context,block)

}

@RequiresApi(Build.VERSION_CODES.N)
suspend fun <T> CompletableFuture<T>.await(): T{
    return suspendCoroutine {
        continuation ->
        whenComplete { result, e ->
            if(e == null) continuation.resume(result)
            else continuation.resumeWithException(e)
        }
    }
}