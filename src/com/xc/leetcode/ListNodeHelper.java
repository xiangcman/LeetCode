package com.xc.leetcode;


public class ListNodeHelper {
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
