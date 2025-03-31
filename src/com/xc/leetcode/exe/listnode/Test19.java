package com.xc.leetcode.exe.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Test19 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = printListFromTailToHead1(ListNodeHelper.initListNode());
        String s = Arrays.toString(integers.toArray());
        System.out.println("s = " + s);
    }

    //借助栈的思想，因为栈是先进后出
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 利用递归的思想来实现往集合中插入元素
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            //这里一直递归到最后一个结点，然后先把最后一个结点添加进去，最后递归回到第一个点，所以就倒序了
            result.addAll(printListFromTailToHead1(listNode.next));
            int val = listNode.val;
            System.out.println("val = " + val);
            result.add(listNode.val);
        }
        return result;
    }
}
