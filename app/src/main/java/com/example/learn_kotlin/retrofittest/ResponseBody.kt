package com.example.learn_kotlin.retrofittest

data class ResponseBody<T>(val code: Int,val msg: String,val data: T)