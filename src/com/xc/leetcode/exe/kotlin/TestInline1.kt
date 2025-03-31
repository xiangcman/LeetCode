package com.xc.leetcode.exe.kotlin

object TestInline1 {
    @JvmStatic
    fun main(args: Array<String>) {
        hello {
            println("hello的闭包")
        }
    }

    inline fun hello(crossinline run: () -> Unit) {
        val runnable = Runnable {
            println("runnable run")
            run()
        }
        runnable.run()
    }

}