package com.xc.leetcode.exe.stack;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Test1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(Integer integer) {
        stack1.push(integer);
    }

    /**
     * 栈2为空的时候，把栈1全部放进去；否则就直接从栈2中取
     *
     * @return
     */
    public Integer pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
