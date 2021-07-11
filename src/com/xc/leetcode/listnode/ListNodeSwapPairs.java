package com.xc.leetcode.listnode;

/*
链表中元素两两交换
 */
public class ListNodeSwapPairs {
    public static void main(String[] args) {
        ListNode listNode = swapPairs(ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5}));
        ListNodeHelper.print(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;//先把node2指向了temp的next节点
            node1.next = node2.next;//接着把node2的next节点给到node1的next结点
            node2.next = node1;//把node1指向node2的next结点
            temp = node1;//把node1指向temp结点
        }
        return dummyHead.next;
    }

}
