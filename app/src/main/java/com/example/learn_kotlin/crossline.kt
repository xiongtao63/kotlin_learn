package com.example.learn_kotlin

fun main() {
    //Lambda 表达式里不允许使用 return，**除非——**这个 Lambda 是内联函数的参数
}
inline fun hello22(postAction:()->Unit){
    println()
}