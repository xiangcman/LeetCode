package com.xc.leetcode.exe.kotlin

import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
//        val test = Test()
//        test.test1(2)

        val testBlock = TestBlock {
            println("testBlock:$this")
        }

        testBlock.test("123")

        val testOut = TestOut<Number>()
        testOut.addAll(ArrayList<Int>())//用了out后，子类的泛型能指向父类泛型
    }
}