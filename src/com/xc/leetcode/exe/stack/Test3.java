package com.xc.leetcode.exe.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 单个队列实现栈
 * 每次在给队列插入元素之前，先把队列中的数据个数记下来，然后从头部开始取出元素，然后放到队列的尾部，这样后插入的元素在队列的头部，先插入的元素在队列的尾部
 * 比如有1，2，3三个数据
 * 第一次push（1）的时候，队列中的元素只有（1）
 * 第二次push（2）的时候，队列中之前有1个元素，所以取出元素（1）放到队列的尾部，所以此时的队列中元素是（2，1）
 * 第三次push（3）的时候，队列中之前有2个元素，所以取出元素（2，1）依次放到队列的尾部，所以此时的队列中元素是（3，2，1）
 * 最终从队列中取的时候，从队列的头部开始取，取出来的数据3，2，1
 */
public class Test3 {
    Queue<Integer> queue = new LinkedList<>();

    public void push(int n) {
        int size = queue.size();
        queue.offer(n);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int poll() {
        return queue.poll();
    }
}
