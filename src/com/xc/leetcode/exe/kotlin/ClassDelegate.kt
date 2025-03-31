package com.xc.leetcode.exe.kotlin

object ClassDelegate {
    interface Printer {
        fun printMessage()
    }

    class RealPrinter : Printer {
        override fun printMessage() {
            println("RealPrinter: 打印内容")
        }
    }

    class ProxyPrinter(printer: Printer) : Printer by printer

    @JvmStatic
    fun main(args: Array<String>) {
        val realPrinter = RealPrinter()
        val proxy = ProxyPrinter(realPrinter)
        proxy.printMessage() // 调用的是 realPrinter 的方法
    }
}