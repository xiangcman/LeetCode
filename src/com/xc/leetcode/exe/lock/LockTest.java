package com.xc.leetcode.exe.lock;

public class LockTest {

    public static void main(String[] args) {
        LockTest lockTest1 = new LockTest("lockTest1");
        LockTest lockTest2 = new LockTest("lockTest2");
        new Thread() {
            @Override
            public void run() {
                super.run();
                lockTest1.test2();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                lockTest2.test2();
            }
        }.start();
    }

    private String name;

    public LockTest(String name) {
        this.name = name;
    }

    public synchronized void test() {
        try {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + "name:" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test1() {
        try {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + "name:" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        synchronized (LockTest.class) {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis() +"name:" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
