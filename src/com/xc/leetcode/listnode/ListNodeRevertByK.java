package com.xc.leetcode.listnode;

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
        ListNode head = listNode;//head只是作为一个指针存储起来
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

        //next表示每k位的最后一个节点
        if (next != null) {
            //此处需要用到head结点，因为最后在拼接的时候实际上是第一个点是作为第一轮的反转最后的一个点，
            //所以在拼接的时候只需要把下次翻转的结果指向这次的头结点的next就行
            head.next = revert(next, k);
        }
        //最后返回的时候用反转后的第一轮的第一个结点作为返回
        return prev;

    }
}
