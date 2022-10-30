package com.joker.kotlin_demo

/**
 * 泛型
 */
fun main() {
//    val coke = Coke()
//    println(coke.teste().price)
//    BlueColor(Blue()).printColor()

    val list = listOf("A","B","'C")
    println("test(list,\"B\")：${test(list,"B")}")
}

/**
 * 泛型接口
 */
interface Drinks<T> {
    fun teste(): T
    fun price(t: T)
}

class Sweet {
    val price = 5
}

class Coke : Drinks<Sweet> {
    override fun teste(): Sweet {
        println("Sweet")
        return Sweet()
    }

    override fun price(t: Sweet) {
        println("Coke price: ${t.price}")
    }

}

/**
 * 泛型类
 */
abstract class Color<T>(var t: T /*泛型字段*/) {
    abstract fun printColor()
}

class Blue {
    val clolr = "Blue"
}

class BlueColor(t: Blue) : Color<Blue>(t) {
    override fun printColor() {
        println("color:${t.clolr}")
    }

}

/**
 * 泛型方法
 */
fun <T> fromJson(json: String, tClass: Class<T>): T? {
    // 获取T的实例
    val t: T? = tClass.newInstance()
    return t
}

/**
 * 泛型约束
 */
fun <T : Comparable<T>?> sort(list: List<T>): Unit {}

fun test2() {
    sort(listOf(1, 2, 3))
//    sort(listOf(Blue())) // 错误： blue 不是Comparable的子类
}

// 多个上界的情况
fun <T> test(list: List<T>, threshold: T): List<T>
        where T : CharSequence, // 第一个
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it }
}

/**
 * 协变和逆变
 * 协变out 对应Java中的上届通配符 extents
 * 逆变in 对应Java中的下届通配符 super
 * Java和kotlin的泛型都属于编译时泛型，在编译时会有类型擦除
 */
