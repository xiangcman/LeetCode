package com.xc.leetcode.exe.kotlin

import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "属性 ${property.name} 被代理了"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("属性 ${property.name} 赋值为 $value")
    }
}