package com.example.learn_kotlin.coroutine

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val start = System.currentTimeMillis()
//        val imagea = loadImage("a")
//        val imageb = loadImage("b")
//        onImageGet(start,imagea,imageb)
        val imagea = async(CommonPool) { loadImage("a") }
        val imageb = async(CommonPool) { loadImage("b") }
        onImageGet(start,imagea.await(),imageb.await())
    }

}

fun onImageGet(start:Long,imagea: String, imageb: String) {
    println("$imagea,,,,$imageb")
    println(System.currentTimeMillis() - start)
}

suspend fun loadImage(url:String):String{
    delay(1000)
    return url
}