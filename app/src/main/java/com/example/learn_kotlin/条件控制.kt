package com.example.learn_kotlin

import kotlin.String as String1

fun main() {
    var name = "11"
    var age = "22"
    notNull(name, age) { println("name: $name") }

    val a = 100
    val b = 200
    val max = if (a>b){
        a
    }else{
        b
    }
    println(max)
    val m = if(a>b)a else b
    println(m)

    //区间
    val x = 9
    if (x in 1..7){
        println("在区间内")
    }
    when(x){
        1 ->{}
        2,3 ->{println("x 2or3")}
        5 ->{
            println("x == 5")
        }
        in 6..10 ->{ println("x in 6..10")}
        !in 10..100->{}
        else ->{
            println("都不是")
        }
    }
    val s:Any = 10
    when(s){
        is String ->{}
        is Int ->{println("INT")}
        else ->{

        }
    }

    //when 也可以用来取代 if-else if链。
    testWhen()
    testWhen1()
}

fun testWhen1() {
    val items = setOf("111","222","333")
    when{
        "111" in items ->{println("111")}
        "222" in items ->{println("222")}
    }
}

fun testWhen() {
    val x = 10
    when{
        x == 1 ->{}
        x == 2 ->{}
        x == 3 ->{}
        else ->{println("不是123")}
    }
}

fun <R> notNull(vararg args: Any?, block: () -> R) =
    when {
        args.filterNotNull().size == args.size -> block()
        else -> null
    }