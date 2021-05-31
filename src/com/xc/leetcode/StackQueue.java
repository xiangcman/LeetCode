package com.xc.leetcode;

import java.util.Stack;

/**
 * 两个栈实现队列
 * 在取数据的时候，只要栈2中还有数据则返回，因为要保证先入栈的数据先要取出来
 * 那如果栈2为空的话，如果此时栈1中压入了数据，
 * 所以要不断地判断栈1中是否还有数据，如果还有数据则需要加入到栈2中才能保证栈1在底下的数据要在栈2上面才能保证先从栈2中出栈，
 * 所以要循环判断栈1中是否还有数据了
 */
public class StackQueue {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(poll());//在poll的时候把stack1中的数据都压入2中了，返回1
        push(5);
        push(6);
        push(7);
        System.out.println(poll());//由于此时不会为空，所以返回2，还有3和4在里面
        System.out.println(poll());//此时还是不为空返回了3，里面还有4
        System.out.println("stack1的大小:" + stack1.size());//size=3
        System.out.println("stack2的大小:" + stack2.size());//size=1

    }

    private static void push(int a) {
        stack1.push(a);
    }

    private static int poll() {
        //如果第二个栈是空的，则进行放数据，否则一直取数据
        if (stack2.isEmpty()) {
            //并且当第一个栈不为空的时候，会一直放数据，直到第一个栈中为空才不放数据
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
