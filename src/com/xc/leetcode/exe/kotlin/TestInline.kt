package com.xc.leetcode.exe.kotlin

object TestInline {
    @JvmStatic
    fun main(args: Array<String>) {
        hello({
            println("我是闭包中的代码")
        }, {
            println("我是noinline闭包中的代码")
        })

        hello1 {
//            return:kotlin不允许非内联函数直接return外层函数，因为非内联函数其实最终是生成一个变量，所以他没办法直接让外层的函数直接被拦截（此处直接编译报错）
        }

        hello2 {
            println("hello2中的闭包代码")
//            return//此处能编译通过，主要是因为内联函数在编译器编译后，会把lambda的代码平铺到调用处，因此可以拦截外层的函数
        }
        hello3({

        }, {
//            return:此处编译会报错，因为lambda加了noinline后，会剔除内联的效果，它会当做一个变量来使用，因此它不会平铺代码，所以它不能拦截外层的方法
        })
        hello4({}, {
            println("hello4中的crossinline代码块")
            return@hello4
        })
        println("main函数代码")

    }

    inline fun hello(run: () -> Unit, noinline run1: () -> Unit) {
        run()
        run1()
    }

    fun hello1(run: () -> Unit) {
        run()
    }

    inline fun hello2(run: () -> Unit) {
        run()
        println("hello2后续代码")
    }

    inline fun hello3(run1: () -> Unit, noinline run: () -> Unit) {
        run1()
        run()
    }

    inline fun hello4(run1: () -> Unit,crossinline  run: () -> Unit) {
        run1()
        hello5 {
            run()
        }
        println("hello4后续代码")
    }

    inline fun hello5(run: () -> Unit) {
        run()
        println("hello5后续代码")
    }
}