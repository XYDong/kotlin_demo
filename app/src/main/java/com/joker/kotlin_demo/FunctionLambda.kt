package com.joker.kotlin_demo

import androidx.core.graphics.component1

/**
 * 在kotlin中，方法可以直接定义在文件中，而不是在类中
 */

fun main() {
//    println(functionLearn(101))
//    Person().test1()
//    Person.test2()
//    println("NumUtil.doubleUtil(2): ${NumUtil.doubleUtil(2)}")
//    println("double(2): ${double(2)}")
//    println(append('H','e','l','l','o'))
//    println("magic : ${magic()}")

    test1()
    println("test3(2,3):${test3(2,3)}")
    println("test4(4,5):${test4(4,5)}")

    test5()

}

fun functionLearn(days: Int): Boolean{
    return days > 100
}

/**
 * 类
 */
class Person{
    /**
     * 成员方法
     */
    fun test1(){
        println("成员方法")
    }

    /**
     * 类似Java的静态方法（伴生对象）
     */
    companion object {
        fun test2(){
            println("companion object 实现类方法")
        }
    }

}

/**
 * 创建静态类（可用来创建工具类）
 */
object NumUtil{
    fun doubleUtil(num: Int): Int{
        return num * 2
    }
}

/**
 * 单表达式方法，当方法返回单个表达式时，可以省略花括号并且在 ” = “之后 指定代码即可
 */

fun double(x: Int) = x * 2


/**
 * 默认值，方法参数可以有默认值，当省略相应的参数时使用默认值。其与Java相比，减少了重载量(方法重载)
 */
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size){

}

/**
 * 可变数量的参数
 */
fun append(vararg char: Char): String {
    val result = StringBuffer()
    char.forEach {
        result.append(it)
    }
    return result.toString()
}

/**
 * 局部方法，可以在方法内定义方法
 */
fun magic(): Int{
    fun foo(v: Int): Int{
        return v*v
    }
    val v1 = (0..100).random()
    return foo(v1)
}

/*************************lambda表达式**********************************/

/**
 * 无参情况
 */
fun test(){
    println("无参数")
}
// lambda 代码
val test1 = { println("无参数") }

/**
 * 有参数
 */
fun test2(a: Int, b:Int): Int{
    return a+b
}
val test3:(Int,Int)-> Int  = { a,b -> a+b }

/**
 * 高级写法
 */
val test4 = {a:Int,b:Int -> a+b}

/**
 * it的用法（隐式参数，也是保留字段）
 */
fun test5(){
    val arr = arrayOf(1,2,3,4,5)
    println(arr.filter { it<5 })
    println(arr.filter { it<5 }.component1())

    val numberMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    numberMap.forEach { (key,value) ->
        println(value)
    }
    // 用下划线表示这个参数不适用，是个占位的
    numberMap.forEach { (_,value) ->
        println(value)
    }



}


















