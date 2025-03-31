package com.xc.leetcode.exe_11_22.listnode;

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
        ListNode listNode = ListNodeHelper.initListNode();
//        List<Integer> integers = printListFromTailToHead(listNode);
//        Integer[] integers1 = integers.toArray(new Integer[integers.size()]);
//        String s = Arrays.toString(integers1);
//        System.out.println("s = " + s);

        List<Integer> result = new ArrayList<>();
        printListFromTailToHead1(listNode, result);
        Integer[] integers1 = result.toArray(new Integer[result.size()]);
        String s = Arrays.toString(integers1);
        System.out.println("s = " + s);
    }

    public static List<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();//栈是先进后出，后进先出，所以链表的尾部节点是先取出来。
        // 栈里面其实是一个数组，每次push的时候是往数组最后的位置插入元素，然后取的时候，也是从末尾取，所以最后加入的是最先取出来的
        List<Integer> result = new ArrayList<>();
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
     * 递归的方式
     * 1,2,3,4,5,6,7,8,9
     *
     * @param listNode
     * @return
     */
    public static void printListFromTailToHead1(ListNode listNode, List<Integer> list) {
        if (listNode == null) {
            return;
        }
        printListFromTailToHead1(listNode.next, list);
        list.add(listNode.val);
    }
}
