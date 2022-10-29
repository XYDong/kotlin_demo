package com.joker.kotlin_demo

import kotlin.math.abs

fun main() {
    println("-----main--------")
//    baseType()
    arrayType()
}

// 数据类型
fun baseType() {
    val num1 = -1.68
    val num2 = 2

    val num3 = 2f

    val int1 = 3

    println("num1:$num1")
    println("num2:$num2")
    println("num3:$num3")
    println("int1:$int1")

    // 求绝对值
    println(abs(num1))
    // 获取值
    println(num1.toInt())

    println(printType(num1))
    println(printType(num2))
    println(printType(num3))
    println(printType(int1))
}

// 数据类型
fun printType(param: Any) {
    println("@param is ${param::class.simpleName} type")
}

/**
 * 数组学习
 */
fun arrayType() {
    // arrayOf
    val array: Array<Int> = arrayOf(1, 2, 3)

    //arrayOfNulls
    val array1: Array<Int?> = arrayOfNulls<Int>(3)
    array1[0] = 4
    array1[1] = 5
    array1[2] = 6

    // array的构造方法
    val array2 = Array(5) {
        (it * it).toString()
    }
//    println(array2.toString())

    // intArrayOf 指定类型的数组
    val x: IntArray = intArrayOf(1, 2, 3)
    println("x[0] + x[1] = ${x[0] + x[1]}")

    //IntArray
    // 初始化大小位5，值为[42,42,42,42,42] 的整型数组
    val array4 = IntArray(5) { 42 }

    //[0,1,2,3,4,5]
    val array5 = IntArray(5) {
        it * 1
    }
    println(array5[4])

    // 数组遍历
    for (i in array) {
        println(i)
    }
    // 带索引的遍历
    for (index in array.indices) {
        println("$index -> ${array[index]}")
    }
    printType("------------------------------------------------------")
    // 遍历元素（带索引）
    for ((index, item) in array.withIndex()) {
        println("$index -> $item")
    }
    printType("------------------------------------------------------")

    // forEach遍历
    array.forEach { println(it) }

    printType("------------------------------------------------------")

    array.forEachIndexed { index, item -> println("$index -> $item") }

}


