package com.example.learn_kotlin

fun main() {
//    forTest()
//    whileTest()
    returnBreakContinue()
}

fun returnBreakContinue() {

//    返回和跳转
    for (i in 1..10){
        if(i == 3) continue
        println(i)
        if(i>5)break
    }
    //Break 和 Continue 标签
    a@for (i in 1..4){
        for (j in 1..4){
            if (i == 2 && j == 3)break@a
            println("i=$i,j=$j")
        }
    }

    val ints =  listOf(1,2,3,4)
    ints.forEach l@{
        if (it == 2)return@l
        println(it)
    }
    ints.forEach {
        if (it == 2)return@forEach
        println(it)
    }
    ints.forEach(fun(value:Int){
        if(value == 2)return
        println(value)
    })
}

fun whileTest() {
    var x = 5
    while (x>0){
        println(x--)
    }
    println("----do...while 使用-----")
    var y = 5
    do {
        println(y--)
    }while (y>10)
}

fun forTest() {
//for (item in collection) print(item)
//for(item:Int in ints){}
    val list = listOf("ddd","222","ssdfs")
    for (i in list){
        println(i)
    }
    for (index in list.indices){
        println("--"+list[index])
    }
    val array = arrayOf("a","b","c")
    for (i in array.indices){
        println(i)
        println(array[i])
    }
    for( (index11,value11) in array.withIndex()){
        println("index=$index11,value=$value11")
    }
}

