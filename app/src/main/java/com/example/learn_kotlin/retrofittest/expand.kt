package com.example.learn_kotlin.retrofittest

import android.view.View
import android.widget.Checkable
import com.example.learn_kotlin.Block
import com.example.learn_kotlin.R


var <T : View> T.lastTime:Long
    get() = getTag(R.id.click_id) as? Long ?: 0
    set(value) = setTag(R.id.click_id, value)

inline fun <T : View> T.singleClick(time:Long = 800, crossinline block: (T) -> Unit){
    setOnClickListener {
        if(clickEnable(time)){
            block(this)
        }
    }
}

inline fun <T: View> T.singleClick(onClickListener: View.OnClickListener,time: Long = 800){
    setOnClickListener {
        if(clickEnable(time)){
            onClickListener.onClick(this)
        }
    }
}

fun<T: View> T.clickEnable(deleyms:Long): Boolean{
    var flag = false
    val current = System.currentTimeMillis()
    if(current - lastTime > deleyms && this is Checkable){
        lastTime = current
        flag = true
    }
    return flag
}

