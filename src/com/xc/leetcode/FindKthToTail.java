package com.xc.leetcode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

/**
 * 求链表中倒数第k个结点
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.initListNode();
        ListNode listNode1 = find(listNode, 3);
        System.out.println("find:" + listNode1.val);
    }

    private static ListNode find(ListNode listNode, int k) {
        ListNode second = listNode;
        ListNode first = listNode;
        //双指针的思想，让第一个指针先走，走到第k个结点后，第二个指针也跟着走，
        // 当第一个节点走到最后的时候，第二个节点位置就是倒数第k个结点的位置
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
