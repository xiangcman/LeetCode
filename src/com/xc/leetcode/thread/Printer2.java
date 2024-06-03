package com.xc.leetcode.thread;

/**
 * 要打印数字1——100，让三个线程打印，
 * 线程1打印1，2，3，4，5
 * 线程2打印6，7，8，9，10
 * 线程3打印11，12，13，14，15
 * 线程1打印16，17，18，19，20
 * 线程2打印21。。。
 * 线程3打印26。。。
 */
public class Printer2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            MyThread thread = new MyThread(i);
            thread.start();
        }
    }

    private static volatile int currentIndex = 1;
    private static volatile int currentNum = 1;
    private static Object lock = new Object();

    private static class MyThread extends Thread {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            super.run();
            synchronized (lock) {
                while (true) {
                    while (currentIndex != index && currentNum <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (currentNum >= 100) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("线程" + index + "打印");
                    for (int i = currentNum; i < 5 + currentNum; i++) {
                        if (i == currentNum + 4) {
                            stringBuilder.append(i);
                        } else {
                            stringBuilder.append(i + ",");
                        }
                    }
                    currentNum += 5;
                    currentIndex++;
                    if (currentIndex >= 4) {
                        currentIndex = 1;
                    }
                    System.out.println(stringBuilder.toString());
                    lock.notifyAll();
                }
            }
        }
    }

}
