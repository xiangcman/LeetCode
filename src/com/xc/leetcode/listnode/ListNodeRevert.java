package com.xc.leetcode.listnode;


public class ListNodeRevert {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.initListNode();
        ListNodeHelper.print(revert(listNode));
    }

    /**
     * 反转的时候把下一个结点的next指向当前的prev就行
     *
     * @param listNode
     */
    private static ListNode revert(ListNode listNode) {
        ListNode next = listNode;//下一个结点
        ListNode prev = null;//上一个结点
        while (listNode != null) {
            next = listNode.next;
            listNode.next = prev;//把上一个结点指向当前结点的next结点，顺序颠倒了
            prev = listNode;
            listNode = next;
        }
        return prev;
    }
}
