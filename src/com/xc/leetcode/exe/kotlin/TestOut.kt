package com.xc.leetcode.exe.kotlin

class TestOut<E> {
    //out:kotlin中的out表示的是协变，相当于java中的extends，而in表示的是逆变，相当于super的用法
    fun addAll(data: MutableCollection<out E>) {

    }
}