package com.example.learn_kotlin

fun main() {
    lateinit var third: Node<Int>
    val second = Node(2, next = {
        println("dddd")
        third
    })
    val first = Node(1, next = { second })

    third = Node(3, next = { first })

    val nodes = generateSequence(first) { it.next() }
    println("Values in the cycle: ${nodes.take(7).joinToString { it.value.toString() }}, ...")
    Foo11().initializationLogic()
}

class Node<T>(val value: T, val next: () -> Node<T>)

class Foo11 {
    //isInitialized 来检测该 lateinit var 是否已初始化
    lateinit var lateinitVar: String
    fun initializationLogic() {
        //sampleStart
        println("isInitialized before assignment: " + this::lateinitVar.isInitialized)
        lateinitVar = "value"
        println("isInitialized after assignment: " + this::lateinitVar.isInitialized)
        //sampleEnd } }
    }
}