package com.joker.kotlin_demo

import android.view.View
import java.util.Calendar

fun main() {
//    println(Shop().isClose)
//    val test = Test()
//    test.setop()
//    test.test()
//
//    val list2 = listOf("1","2","3")
//    println(DataUtil.isEmpty(list2))

    testStudent()
}

/**
 * 类有主和次构造方法
 */
class KotlinClass constructor(name: String) { // 主构造constructor 可以省略
    // 次构造方法必须要先调用主构造方法 ： this()
    constructor(view: View, name: String) : this(name) {
        println("name:$name")
    }

    constructor(view: View, index: Int, name: String) : this(name) {
        println("name:$name")
    }
}


/**
 * kotlin中的类都是final类型的，都是不能被继承的
 * 如果需要继承，需要给父类加上open
 */

open class Animal(age: Int) {
    init {
        println("age:$age")
    }

    /**
     * 父类方法和成员变量默认也是不能被重写的，重新的话需要添加open关键字
     */
    open val foot: Int = 0
    open fun eat() {

    }
}

/**
 * 派生出Dog类
 */
class Dog(age: Int) : Animal(age)

/**
 * 第二种写法
 */
class Dog2 : Animal {
    constructor(age: Int) : super(age)

    override val foot: Int
        get() = super.foot

    override fun eat() {}

}

/**
 * 属性的声明
 */
class Shop {
    val name: String = "Android"
    var address: String? = null
    val isClose: Boolean
        get() = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 11
    var score: Float = 0.0f
        get() = if (field < 0.2f) 0.2f else field * 1.5f
        set(value) {
            println(value)
        }
}

/**
 * 延迟初始化
 */
class Test {
    lateinit var shop: Shop
    fun setop() {
        shop = Shop()
        shop.address = "US"
    }

    fun test() {
        // :: 表示创建成员变量的应用
        if (::shop.isInitialized) println(shop.address)
    }
}

/**********************抽象和接口******************************/

/**
 * 抽象类
 */
abstract class Printer {
    abstract fun print()
}

class FilePrinter : Printer() {
    override fun print() {
        TODO("Not yet implemented")
    }

}

/**
 * 接口
 */
interface Study {
    val time: Int // 抽象的变量
    fun discuss()
    fun learnCourses() {
        println("Android 架构师")
    }
}

/**
 * 抽象的变量需要在实现类里边重写
 */
class StudyAS(override val time: Int) : Study {
    override fun discuss() {
        TODO("Not yet implemented")
    }

}

interface A{
    fun foo(){
        println("A")
    }
}
interface B{
    fun foo(){
        println("B")
    }
}
class C: A,B{
    override fun foo() {
        // 如果要调用父类的方法，需要指定父类类型
        super<A>.foo()
    }

}

/**
 * 数据类不能被继承
 */
data class Address(val name: String, val number: Int){
    var city: String? = null
    fun print(){
        println(city)
    }
}
/**
 * 对象表达式
 */
open class Address2(name: String){
    open fun print(){

    }
}

class Shop2(){
    var address: Address2? = null
    fun addAddress(address2: Address2){
        this.address = address2
    }
}

fun test3(){
    // 使用object 声明一个对象
    Shop2().addAddress(object : Address2("android"){
        override fun print(){
            super.print()
        }
    })
}

/**
 * 使用如下这种方式 object {} 可以创建简单的类，也是个静态对象
 */
fun foo(){
    val adHoc = object {
        val x: Int = 0
        val y: Int =0
    }
}

/**
 * 静态类（有名字的）
 */
object DataUtil {
    fun <T> isEmpty(list: List<T>?) : Boolean{
        return list?.isEmpty() ?: false
    }
}

/**
 * 伴生对象
 *
 */

class Student(val name: String){
    companion object{
        //可以看作是Java的静态对象和静态方法
        val student = Student("android")
        fun study(){
            println("Android 架构师")
        }
    }
}

fun testStudent(){
    println(Student.student)
    Student.study()
}





