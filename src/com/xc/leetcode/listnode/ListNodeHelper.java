package com.xc.leetcode.listnode;


public class ListNodeHelper {
    /**
     * 根据数组得到一个链表
     *
     * @param array
     * @return
     */
    public static ListNode getListNodeByArray(int[] array) {
        ListNode listNode = new ListNode(-1);
        ListNode head = listNode;
        for (int i = 0; i < array.length; i++) {
            ListNode current = new ListNode(-1);
            current.val = array[i];
            listNode.next = current;
            listNode = current;
        }
        return head.next;
    }

    public static ListNode initListNode() {
        ListNode prev = null;
        ListNode my = null;
        for (int i = 0; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            if (my == null) {
                my = listNode;
            }
            if (prev != null) {
                prev.next = listNode;
            }
            prev = listNode;
        }
        return my;
    }

    /**
     * 初始化一个环装的链表
     *
     * @return
     */
    public static ListNode initLoopListNode() {
        ListNode prev = null;
        ListNode my = null;
        for (int i = 0; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            if (my == null) {
                my = listNode;
            }
            if (prev != null) {
                prev.next = listNode;
            }
            prev = listNode;
        }
        prev.next = my;
        return my;
    }

    public static void print(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append(",");
            listNode = listNode.next;
        }
        sb.append("]");
        System.out.println("print:" + sb.toString());
    }
}
