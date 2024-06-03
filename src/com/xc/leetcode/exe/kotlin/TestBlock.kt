package com.xc.leetcode.exe.kotlin

class TestBlock(val block: String.() -> Unit) {
    fun test(params: String) {
        params.block()//该写法等同于：block.invoke(params)
    }
}