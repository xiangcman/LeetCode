package com.xc.leetcode.exe.array;

public class Singleton {
    //定义一个该类的静态变量
    public volatile static Singleton singleton;

    //构造方法私有化
    private Singleton() {

    }

    public static Singleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (singleton == null) {
            //同步块，线程安全地创建实例
            synchronized (Singleton.class) {
                //再次检查实例是否存在，如果不存在才真正地创建实例，如果不判断直接创建会导致创建了多份对象
                if (singleton == null) {
                    singleton = new Singleton();
                    //1.分配内存
                    //2.对象初始化
                    //3.引用指向刚分配的内存地址
                }
            }
        }
        return singleton;
    }
}
