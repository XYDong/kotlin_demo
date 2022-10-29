package com.joker.kotlin_demo

/**
 * 在kotlin中，方法可以直接定义在文件中，而不是在类中
 */

fun main() {
    println(functionLearn(101))
    Person().test1()
    Person.test2()
    println("NumUtil.doubleUtil(2): ${NumUtil.doubleUtil(2)}")
    println("double(2): ${double(2)}")
    println(append('H','e','l','l','o'))
    println("magic : ${magic()}")
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
