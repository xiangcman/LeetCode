package com.xc.leetcode.thread;

/**
 * threadNum:表示线程个数
 * numSize:表示数字的个数
 * 打印规则
 * thread0-0
 * thread1-1
 * thread2-2
 * thread3-3
 * thread0-4
 * thread1-5
 * thread2-6
 * thread3-7
 */
public class Printer {

    private int threadNum = 4;
    private int numSize = 8;

    private volatile int current;
    private volatile int currentIndex;
    private Object lock = new Object();

    public static void main(String[] args) {
        new Printer();
    }

    public Printer() {
        for (int i = 0; i < threadNum; i++) {
            MyThread thread = new MyThread("name" + i, i);
            thread.start();
        }
    }

    private class MyThread extends Thread {
        private int index;

        public MyThread(String name, int index) {
            super(name);
            this.index = index;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (true) {//index:0 1 2 3
                    //current 0 1 2 3 4 5 6 7
                    //numsize 8
                    //0
//                    while (current % threadNum != index) {
                    while (currentIndex != index) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + "--current:" + current);
                    current++;
                    currentIndex++;
                    if (currentIndex == threadNum) {
                        currentIndex = 0;
                    }
                    if (current == numSize) {
                        current = 0;
                    }
                    lock.notifyAll();
                }
            }
        }
    }

}
