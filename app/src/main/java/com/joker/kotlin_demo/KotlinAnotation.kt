package com.joker.kotlin_demo

/**
 * kotlin注解学习
 */

fun main() {
    val api = ApiGetArticles()
    fire(api)
}

/**
 * 注解定义
 * 和一般声明类似，只是在class前面加上了annotation修饰符
 *
 * kotlin 注解主要有：
 * @Target: 定义注解能否应用于哪些目标
 * @Retention： 注解的保留期
 * @Repeatable： 标注注解可以多次应用于相同的声明或者类型
 * @MustBeDocumented: 修饰的注解将被文档工具提取到API文档中
 */
@Target(AnnotationTarget.CLASS)
annotation class ApiDoc(val value: String)

@ApiDoc(value = "修饰类")
class Box{

//    @ApiDoc(value = "修饰字段")
//    val size = 6
//
//    @ApiDoc(value = "修饰方法")
//    fun test(){
//
//    }
}

/**
 * 组定义注解实现API调用时的请求方法检查
 */
enum class Method{
    GET,POST
}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class HttpMethod(val method: Method)

interface Api{
    val name: String
    val version: String
        get() = "1.0"
    fun request()
}

@HttpMethod(Method.GET)
class ApiGetArticles : Api{
    override val name: String
        get() = "/api.articles"

    @ResponseConvert(convert = HttpConvert.GSON)
    override fun request() {
        println("接口正在请求")
    }
}

fun fire(api: Api){
    val annotations = api.javaClass.annotations
    val method = annotations.find{ it is HttpMethod } as? HttpMethod
    println("通过注解得知该接口通过：${method?.method} 方式请求")
    val methods = api.javaClass.methods
    methods.forEach { it ->
        val convert = it.annotations.find { it is ResponseConvert } as? ResponseConvert
        if (convert != null) {
            println("通过注解得知该接口请求头：${convert.convert}")
        }

    }
}

/**
 * 方法注解作业
 */
enum class HttpConvert{
    GSON,FASTJSON
}


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ResponseConvert(val convert: HttpConvert)
