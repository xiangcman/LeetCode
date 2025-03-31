package com.xc.leetcode.exe.lock;

public class LockTest {

    public static void main(String[] args) {
        LockTest lockTest1 = new LockTest("lockTest1");
        LockTest lockTest2 = new LockTest("lockTest2");
        new Thread() {
            @Override
            public void run() {
                super.run();
                lockTest1.test("lockTest1");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                lockTest2.test("lockTest2");
            }
        }.start();
    }

    private String name;

    public LockTest(String name) {
        this.name = name;
    }

    public static synchronized void test(String name) {//synchronized修饰的静态方法，实例之间会持有同一把锁，所以会阻塞
        try {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + "name:" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test1() {//使用synchronized修饰的非静态方法，实例之间不会持有同一把锁，所以不会阻塞
        try {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + "name:" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        synchronized (LockTest.class) {//此处演示的是类锁和对象锁的区别，
            // 此处如果是LockTest.class的话，则是类锁，所有的对象都会持有这一把锁，所以实例之间会阻塞
            //如果是LockTest.this的话，则是对象锁，所有的对象会持有不同的锁，所以实例之间不会阻塞
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis() +"name:" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
