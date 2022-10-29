package com.joker.kotlin_demo

import kotlin.math.abs

fun main() {
    println("-----main--------")
//    baseType()
//    arrayType()
    collectionType()
//    collectionSort()
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

/**
 * 集合学习
 */
fun collectionType(){
    // 不可变集合
    val stringList = listOf("one","two","one")
    println(stringList)

    // 不重复集合
    val stringSet = setOf("one","two","one")
    println(stringSet)

    // 可变集合
    val numbers = mutableListOf(1,2,3,4)
    numbers.add(5)
    numbers.removeAt(1)
    numbers[0] = 0
    println(numbers)

    // 集合删除元素
    val hello = mutableSetOf("h","e","l","l","o")
    hello.remove("o")
    println(hello)

    // 集合的加减操作
    hello+= setOf("w","o","r","l","d")
    println(hello)

    // map<K,V> 不是Collection 接口的继承者，但是它也是Kotlin 的一种集合类型
    val numberMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    println("All keys: ${numberMap.keys}")
    println("All values: ${numberMap.values}")
    // 检查key是否在map中
    if ("key2" in numberMap) println("value by key key2:${numberMap["key2"]}")
    if (1 in numberMap.values) println("value by value 1")

    /**
     * Q1 两个具有相同键值对，但顺序不同的map 相等吗？ 为什么？
     * 相等：源码分析得出结论
     */
    val anotherMap = mapOf("key1" to 1, "key3" to 3, "key2" to 2)
    println("anotherMap == numberMap : ${numberMap == anotherMap}")
    anotherMap.equals(numberMap)

    /**
     * Q2 两个具有相同元素，但顺序不同的lsit相等吗？为什么？
     * 不相等，因为在顺序对比时，要对比相同顺序下的数据是否相等
     */
    val stringList1 = listOf("one","one","two")
    println("stringList1 == stringList : ${stringList1 == stringList}")
    stringList1.equals(stringList)





}

/**
 * 集合排序
 */
fun collectionSort(){
    val numbers3 = mutableListOf(1,2,3,4)
    // 随机排序
    numbers3.shuffle()
    println(numbers3)

    numbers3.sort() // 从小到大排序
    println(numbers3)
    numbers3.sortDescending() // 从大到小排序
    println(numbers3)

    // 条件排序
    data class Language(var name: String, var score: Int)

    val languageList = mutableListOf<Language>()
    languageList.add(Language("Java", 80))
    languageList.add(Language("Kotlin", 90))
    languageList.add(Language("Dart", 99))
    languageList.add(Language("C", 80))

    // sortBy 单条件排序
    languageList.sortBy { it.score }
    println(languageList)
    // 多条件排序
    languageList.sortWith(compareBy(
        // it是lambda中的隐式参数
        {it.score},
        {it.name}
    ))
    println(languageList)

    //
}


