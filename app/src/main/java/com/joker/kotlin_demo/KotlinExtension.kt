package com.joker.kotlin_demo

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.Size

/**
 * kotlin的扩展函数
 */

fun main() {
    val list = mutableListOf(1, 2)
    list.swap(0, 1)
    println("list.swap(0,1):$list")

    val listString = mutableListOf("A","B","C")
    listString.swap(0,2)
    println("listString.swap(0,2):$listString")

    val str = "ABC"
    println(str.lastChar)

    Jump.print("123") // 相当于Java中的静态方法

    testApply()
}


/**
 * 普通扩展
 * 反编译后是通过静态方法实现
 */
//fun MutableList<Int>.swap(index1: Int,index2: Int){
//    val temp = this[index1]
//    this[index1] = this[index2]
//    this[index2] = temp
//}

/**
 * 泛型扩展
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 扩展属性
 * 限制：不能拥有任何状态，也不能添加任何字段到现有Java对象实例
 */
val String.lastChar: Char get() = this[this.length -1]

/**
 * 给类的伴生对象添加扩展属性
 */
class Jump{
    companion object {

    }
}

fun Jump.Companion.print(str: String){
    println(str)
}

/**
 * 常用扩展学习
 * let
 * run
 */
/**
 * let函数
 * 实际上是一个作用域函数，当你需要去定义一个变量在特定的作用月范围内，就可以使用let
 * 另一个作用是避免写一些判断null的操作
 */
fun testLet(str: String?){
    // 避免为null的操作
    str?.let {
        println(str)
    }
    // 限制作用域 str2 就被限制在了let块里边
    str.let {
        val str2 = "let作用域"
        println(str2)
    }
}

/**
 * run扩展
 * 只接收一个lambda函数作为参数，以闭包的形式返回最后一行的值
 * 或者指定的return的表达式，在run函数中，可以直接方位实例的公有属性和方法
 */
data class Room(val address: String, val price: Float, val size: Float)

fun testRun(room: Room){
    // room.address
    // room.price
    // room.size
    room.run {
        println("Room: $address, $price, $$size")
    }
}

/**
 * apply扩展
 * 调用某对象的apply函数，在函数范围内，可以任意调用该对象的任意方法，并返回该对象，
 * 类似Java中的builder
 * 和run不同的是，run函数返回的是闭包形式的最后一行代码的值
 * 而apply返回的是传入对象本身
 */
fun testApply(){
    // 可用于一些对象的初始化上
    ArrayList<String>().apply {
        add("1")
        add("2")
        add("3")
        add("4")
    }.let {
        println(it)
    }
}

/*---------案例：使用Kotlin扩展为控件绑定监听器减少模板代码-----------------*/
// 为activity添加find方法，用于通过资源id获取控件
fun <T: View> Activity.find(@IdRes id: Int): T {
    return findViewById(id)
}
// 为Int添加onClick扩展方法，用于为资源id对应的控件添加onclick监听
fun Int.onClick(activity: Activity, click: () -> Unit){
    activity.find<View>(this).apply {
        setOnClickListener{
            click()
        }
    }
}



