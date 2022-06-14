package com.example.learn_kotlin

fun main() {
//函数被内联之后，它内部的那些函数类型的参数就不再是对象了，因为它们的壳被脱掉了,解决办法加noinline
    hello11({
        println("hello1")
    },{
        println("hello2")
    })
}

inline fun hello11(preAction:() ->Unit, noinline postAction: ()->Unit): ()->Unit{
    preAction()
    println("hello")
    postAction()
    return postAction
}