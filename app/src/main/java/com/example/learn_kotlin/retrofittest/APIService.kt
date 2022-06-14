package com.example.learn_kotlin.retrofittest

import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @POST("/user/login")
    @FormUrlEncoded
    fun <T> login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<ResponseBody<T>>

    @GET("get")
    @FormUrlEncoded
    fun <T> logout(
        @Query("username") username: String
    ): Call<ResponseBody<T>>
}