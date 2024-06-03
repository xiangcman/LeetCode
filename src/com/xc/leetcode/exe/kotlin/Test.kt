package com.xc.leetcode.exe.kotlin


class Test {
    fun test(test: Test) {
        val b = this === test
        println("result:$b")
    }

    fun test1(i: Int) {
        val j = 1
        val b = j === i
        println("result:$b")
    }

    override fun equals(other: Any?): Boolean {
        return true
    }
}