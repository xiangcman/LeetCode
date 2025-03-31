package com.xc.leetcode.exe.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * 每次在push的时候，先把元素放到队列2中，然后把队列1中的所有元素取出来给到队列2，最后把队列2和队列1进行互换，那么此时队列2是空的，队列1是原来队列2的元素
 * 比如有1，2，3三个数据
 * 第一次push（1）到队列2，由于队列1是空的，所以互换后队列1中有（1），队列2是空的
 * 第二次push（2）到队列2，队列1不是空的，会把队列1中的（1）放到队列2中，此数队列2的数据是（2，1），然后又把队列1和队列2互换，互换后，队列1的数据是（2，1），队列2是空的
 * 第三次push（3）到队列2，队列1不是空的，会把队列1中的（2，1）放到队列2中，此时队列2的数据是（3，2，1），然后又把队列1和队列2互换，互换后，队列1的数据是（3，2，1），队列2是空的
 * 所以最后从队列1取的时候，从队列的头部开始取，取出来的数据3，2，1
 */
public class Test2 {
    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int n) {
        queue2.offer(n);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }
}
