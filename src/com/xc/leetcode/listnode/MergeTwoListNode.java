package com.xc.leetcode.listnode;

/**
 * 合并两个递归链表，并且保证合并后的链表也是递归增长
 * 比如1->3->5->7和2->4->6->8合并，合并后的结果是1->2->3->4->5->6->7->8
 */
public class MergeTwoListNode {
    public static void main(String[] args) {
        ListNode merge = merge(ListNodeHelper.getListNodeByArray(new int[]{1, 3, 5, 7}), ListNodeHelper.getListNodeByArray(new int[]{2, 4, 6, 8}));
        ListNodeHelper.print(merge);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
