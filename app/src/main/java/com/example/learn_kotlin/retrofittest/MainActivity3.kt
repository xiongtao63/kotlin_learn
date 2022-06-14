package com.example.learn_kotlin.retrofittest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.learn_kotlin.R

class MainActivity3: AppCompatActivity(R.layout.main_activity3),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginBtn = findViewById<Button>(R.id.btn_login)
        val loginBtn1 = findViewById<Button>(R.id.btn_login1)
//        loginBtn.singleClick(3000) {
//            println("11111")
//        }
//        loginBtn1.setOnClickListener {
//            println("22222")
//        }
        loginBtn.singleClick(this,2000)
        loginBtn1.singleClick(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> {
                println("11111")
            }
            R.id.btn_login1 ->{
            println("222")
            }
        }
    }
}