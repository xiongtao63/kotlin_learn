package com.example.learn_kotlin.retrofittest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object{
        val retrofitClient  = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val apiService = retrofitClient.create(APIService::class.java)

    }

    fun login(username:String,password:String){
        val call = apiService.login<User>(username, password)
        val execute = call.execute()
        call.enqueue(object: Callback<ResponseBody<User>>{
            override fun onResponse(
                call: Call<ResponseBody<User>>,
                response: Response<ResponseBody<User>>
            ) {
                val body = response.body()
            }

            override fun onFailure(call: Call<ResponseBody<User>>, t: Throwable) {
                System.out.println("连接失败");
            }

        })

    }
}