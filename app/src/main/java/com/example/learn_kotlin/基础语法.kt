package com.example.learn_kotlin

import java.lang.Integer.parseInt

fun sum(a:Int,b:Int):Int{
    return a + b
}
fun main() {
    val r  = sum2(1,2)
    println(r)
    vars(1,3,4,5,7)
    println()
    println(sumlambda(1,5))

    //字符串模板
    var a = 1
    val b = "this is $a"
    a = 2
    val c = "${b.replace("is","was")},but now is $a"
    println(c)
    val args = Array<String>(5,{"0"})
    for (a in 1..4){
        args[a] = a.toString()
    }
    test(args)
    println(getStringLength("aaaa"))

    range()
}
fun sum1(a: Int,b: Int)=a+b
public fun sum2(a: Int,b: Int):Int=a+b

fun printSum(a: Int,b: Int):Unit{
    print(a+b)
}
public fun printSum1(a: Int,b: Int){
    printSum(a,b)
}
//可变长参数
fun vars(vararg a:Int){
    for (item in a){
        print(item)
    }
}
//lambda表达式
val sumlambda:(Int,Int)-> Int = { x,y -> x+y}

//null判断
//var age:String? = "23"
//val ages = age!!.toInt()
//val age1 =  age?.toInt()
//val age2 = age?.toInt() ?:-1

//类型后面加?表示可为空
var age: String? = "23"
//抛出空指针异常
val ages = age!!.toInt()
//不做处理返回 null
val ages1 = age?.toInt()
//age为空返回-1
val ages2 = age?.toInt() ?: -1

fun test(args:Array<String>){
    if(args.size<2){
        print("Two integers expected")
        return
    }
    val x = parseInt(args[0])
    val y = parseInt(args[1])
    if(x != null && y !=null){
        println(x * y)
    }
}
//类型检测和自动转换
fun getStringLength(obj:Any):Int?{
    if(obj is String && obj.length>0){
        return obj.length
    }
//    if(obj !is String){
//        return null
//    }
//    return obj.length
    return null
}

fun range(){
//    for (i in 0..10)print(i)
//    for (i in 4 downTo 1)print(i)
    var i:Int = 3
    if(i in 1..3){
        print(i)
    }
    for (i in 0..10 step 2)print(i)
    println()
    for(i in 4 downTo 1 step 2) print(i)
    println()
    for (i in 3 until 6) print(i) //使用 until 函数排除结束元素

    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
}

