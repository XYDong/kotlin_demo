package com.joker.kotlin_demo

import com.joker.kotlin_demo.Result
import kotlin.collections.List
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.filter
import kotlin.collections.forEach
import kotlin.collections.listOf
import kotlin.collections.mapOf

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

//    test1()
//    println("test3(2,3):${test3(2,3)}")
//    println("test4(4,5):${test4(4,5)}")
//
//    test5()

//    val list = listOf(1,2,3)
//    val sumList = list.sum { println("it:$it") }
//    println("sumList:$sumList")
//
//    val list2 = listOf("1","2","3")
//    println("list2 list2.toIntSum(): ${list2.toIntSum()(2)}")

    testClosure(1)(2) {
        println("it:${it}")
    }

    test11()

    literal()
}

fun functionLearn(days: Int): Boolean {
    return days > 100
}

/**
 * 类
 */
class Person {
    /**
     * 成员方法
     */
    fun test1() {
        println("成员方法")
    }

    /**
     * 类似Java的静态方法（伴生对象）
     */
    companion object {
        fun test2() {
            println("companion object 实现类方法")
        }
    }

}

/**
 * 创建静态类（可用来创建工具类）
 */
object NumUtil {
    fun doubleUtil(num: Int): Int {
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
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {

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
fun magic(): Int {
    fun foo(v: Int): Int {
        return v * v
    }

    val v1 = (0..100).random()
    return foo(v1)
}

/*************************lambda表达式**********************************/

/**
 * 无参情况
 */
fun test() {
    println("无参数")
}

// lambda 代码
val test1 = { println("无参数") }

/**
 * 有参数
 */
fun test2(a: Int, b: Int): Int {
    return a + b
}

val test3: (Int, Int) -> Int = { a, b -> a + b }

/**
 * 高级写法
 */
val test4 = { a: Int, b: Int -> a + b }

/**
 * it的用法（隐式参数，也是保留字段）
 */
fun test5() {
    val arr = arrayOf(1, 2, 3, 4, 5)
    println(arr.filter { it < 5 })
    println(arr.filter { it < 5 }.component1())

    val numberMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    numberMap.forEach { (key, value) ->
        println(value)
    }
    // 用下划线表示这个参数不适用，是个占位的
    numberMap.forEach { (_, value) ->
        println(value)
    }
    numberMap.apply { }


}


/**
 * 高阶函数-函数作为参数
 */

fun List<Int>.sum(callback: (Int) -> Unit): Int {
    var result = 0
    for (v in this) {
        result += v
        callback(v)
    }
    return result
}

/**
 * 高阶函数 - 函数作为返回值
 * 需求：实现一个能对集合元素进行求和的高阶函数，并且返回一个声明为（scale： Int）-> Float的函数
 *
 */
fun List<String>.toIntSum(): (scale: Int) -> Float {
    println("第一层函数")
    return fun(scale): Float {
        var result = 0f
        for (v in this) {
            result += v.toInt() * scale
        }
        return result
    }
}

/************************闭包*****************************/

/**
 * 闭包的特性：
 * 1. 方法可以作为另一个方法的返回值或者参数，还可以作为一个变量的值
 * 2. 方法可以嵌套定义，既可以在一个方法内定义另一个方法
 * 闭包的好处：
 * 1. 加强模块化：以简单方式开发较小的模块，
 * 2. 抽象
 * 3. 灵活
 * 4. 简化代码
 */

/**
 * 需求：实现一个接受一个testClosure方法，该方法要接受一个Int类型的V1参数，
 * 同时能够返回一个声明为（v2：Int,(Int)） -> Unit)的函数，并且这个函数能够计算v1he v2的和
 */
fun testClosure(v1: Int): (v2: Int, (Int) -> Unit) -> Unit {
    return fun(v2: Int, printer: (Int) -> Unit) {
        printer(v1 + v2)
    }
}

/**
 * 解构声明：将对象中的字段解构出来
 */
data class Result(val message: String, val code: Int)

fun test11() {
    var result = Result("success", 0)
    val (message, code) = result
    println("message + code = ${message + code}")
}

/**
 * 匿名方法，没有方法名
 * 也是一个表达式方法
 */
val fun1 = fun(x: Int, y: Int): Int = x + y

/**
 * 方法的字面值
 * 就是一段代码，可以当作参数传递
 */
fun literal() {
    // 定义一个方法
    val temp: ((Int) -> Boolean)?
    //方法字面值
    temp = { num -> (num > 10) }
    println("temp: ${temp(10)}")
}














