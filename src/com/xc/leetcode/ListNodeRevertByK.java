package com.xc.leetcode;

/**
 * 每k位进行旋转链表
 */
public class ListNodeRevertByK {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.initListNode();
        ListNode revert = revert(listNode, 3);
        ListNodeHelper.print(revert);
    }

    private static ListNode revert(ListNode listNode, int k) {
        //先初始化一个head结点
        ListNode head = listNode;
        ListNode next = null;//下一个结点
        ListNode prev = null;//上一个结点
        int i = 0;
        while (listNode != null && i < k) {
            next = listNode.next;
            listNode.next = prev;//把上一个结点指向当前结点的next结点，顺序颠倒了
            prev = listNode;
            listNode = next;
            i++;
        }

        if (next != null) {
            //此处需要用到head结点，因为最后在拼接的时候实际上是第一个点是作为第一轮的反转最后的一个点
            head.next = revert(next, k);
        }
        //最后返回的时候用反转后的第一轮的第一个结点作为返回
        return prev;

    }
}
