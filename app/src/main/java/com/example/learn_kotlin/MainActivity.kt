package com.example.learn_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        textView.text = "ddd"
        MainUi().setContentView(this@MainActivity)
    }
}
class MainUi : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui){
        verticalLayout {
            gravity = Gravity.CENTER
            lparams(matchParent, matchParent)
            editText {
                hint = "userName"
                gravity = Gravity.CENTER
                addTextChangedListener(object : TextWatcher{
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        TODO("Not yet implemented")
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        TODO("Not yet implemented")
                    }

                    override fun afterTextChanged(s: Editable?) {
                        TODO("Not yet implemented")
                    }

                })
            }.lparams(width = dip(250), height = 200)
            editText {
                gravity = Gravity.CENTER
                hint = "password"
                top = 20
            }.lparams(width = dip(250), height = 200)
            button("list"){
                backgroundColor = Color.parseColor("#FF9999")
                alpha = 0.6f
                onClick {
                    startActivity<AnkoTestActivity>("a" to "alpha")
                }
                onLongClick {
                    toast("dddd")
                }
            }.lparams(dip(250),dip(50))
            button("setting") {
                backgroundColor = Color.parseColor("#FF7777")
                alpha = 0.5f
                // 点击事件
                onClick {
                    // anko封装的intent携带值跳转
                    startActivity<AnkoTestActivity>("aulton" to "aulton")
                }
            }.lparams(dip(250), dip(50)) {
                topMargin = dip(16)
            }

            button("custom_view") {
                backgroundColor = Color.parseColor("#FF7777")
                alpha = 0.5f
                // 点击事件
                onClick {
                    // anko封装的intent携带值跳转
                    startActivity<AnkoTestActivity>("aulton" to "aulton")
                }
            }.lparams(dip(250), dip(50)) {
                topMargin = dip(16)
            }
        }
    }
}