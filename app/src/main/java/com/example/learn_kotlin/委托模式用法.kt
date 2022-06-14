package com.example.learn_kotlin

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main() {
    //类委托

    //属性委托
    var foo = Foo()
    println(foo.p)
    foo.p = "dd"
}
//类委托---------------------------------------------------------------------------------------------
//传统的实现接口
class DelegatingCollection<T> : Collection<T>{
    private val innerList = mutableListOf<T>()
    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean = innerList.contains(element)


    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()

}
//类委托实现接口  没有写出来的方法全部都交给委托来实现。
class DelegatingCollection2<T>(private val innerList: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerList{
    private var addedSum = 0
    override fun add(element: T): Boolean {
        addedSum++
        return innerList.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        addedSum += elements.size
        return innerList.addAll(elements)
    }
}
//没有写出来的方法全部都交给委托来实现。
class DelegatingCollection3<T>(private val innerList: Collection<T> = mutableListOf()): Collection<T> by innerList {
    override fun isEmpty(): Boolean {
        return innerList.isEmpty()
    }
}

//属性委托---------------------------------------------------------------------------------------------
class Foo {
    private val delegate = Delegate()
    var p: String by delegate
//    set(value) = delegate.setValue(this,KProperty(),value)
//    get() = delegate.getValue(this,KProperty<String>())
}
//自定义委托类
class Delegate{
    operator fun getValue(thisRef:Any?, property:KProperty<*>): String{
        return "$thisRef,thank you for delegating '${property.annotations}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}
//data class ResourceID<T>(public val image_id:String,val text_id:String)
//class ResourceLoader<T>(id: ResourceID<T>) {
//    operator fun provideDelegate(thisRef: MyUI,property: KProperty<*>): ReadOnlyProperty<MyUI,T>{
//
//        checkProperty(thisRef,property.name)
//        return ReadOnlyProperty()
//    }
//    private fun checkProperty(thisRef: MyUI, name: String) {  }
//}
//class MyUI{
//    val image by bindResource(ResourceID.image_id)
//
//}
//
//fun <T> bindResource(id:ResourceID<T>):ResourceLoader<T>{
//    return null
//}
