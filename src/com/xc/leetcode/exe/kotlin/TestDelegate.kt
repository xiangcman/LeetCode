package com.xc.leetcode.exe.kotlin

object TestDelegate {
    var message by Delegate()
    @JvmStatic
    fun main(args: Array<String>) {
        message= "123"
        println(message)
    }
}