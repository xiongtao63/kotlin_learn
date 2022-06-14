package com.example.learn_kotlin

fun main() {
    //分组 groupBy
    val numbers = listOf("one", "two", "three","three", "four", "five")
    val numbers1 = listOf(1, 2, 3, 4, 5)
    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy { it.first()}.mapValues { (_,list) -> list.size })
    println(numbers.groupBy(keySelector = {it.first()}, valueTransform = {it.toUpperCase()}))
    println(numbers1.groupBy { it > 3 })

    //groupingBy()   在分组后，对所有的分组进行一次操作
    println(numbers.groupingBy { it.first() }.eachCount())
    println(numbers.groupingBy { it.first() }.keyOf("three"))


    // plus/minus 加减
    val plus = numbers.plus("six")
    val plus1 = numbers + "six"
    println(plus1)
    val plus2 = numbers.minus("two")
    val plus3 = numbers - "three"
    val plus4 = numbers - listOf("three")
    println(plus2)
    println(plus3)
    println(plus4)

    val map = mapOf("key" to "11")
    val empty = map - "key"
    println(map)
    println(empty)

    //minOf() 和 maxOf()
    val list1 = listOf("x","y")
    val list2 = listOf("1","2","3")
    val minSize = minOf(list1.size,list2.size)
    val maxSize = maxOf(list1,list2, compareBy { it.size })
    println(minSize)
    println(maxSize)

    //数组list 实例化
    val squares = List(10){index -> 2*index }
    val mutableList = MutableList(10){1}
    println(squares)
    println(mutableList)

    //Map.getValue()   withDefault 默认值
    println(map.getValue("key"))
    val mapWithDefault = map.withDefault { k -> k.length }
    println(mapWithDefault.getValue("kkk"))

    //contentEquals  数组处理函数比较
    //（ contentEquals 和 contentDeepEquals ），哈希码计算（ contentHashCode 和 contentDeepHashCode ），
    //以及转换成一个字符串（ contentToString 和 contentDeepToString ）
    val array = arrayOf("a","b","c")
    val array1 = arrayOf("a","b","c")
    println(array.toString())
    println(array.contentToString())
    println(array.contentEquals(array1))
    println(array.contentDeepEquals(array1))


}
