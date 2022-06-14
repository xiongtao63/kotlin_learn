package com.example.learn_kotlin

fun main() {
    val ss = null

    System.out.println("===="+ss.toString())

    val map = mapOf("user_no" to null)

    val isN = map["user_no"].toString().isNotEmpty()
    System.out.println(""+isN)
}