package com.xc.leetcode.exe.kotlin

inline fun <reified T> getTypeName(): String {
    return T::class.java.simpleName  // 运行时获取泛型类型
}

fun main() {
    println(getTypeName<String>()) // 编译后变为 println("String")
}