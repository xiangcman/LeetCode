package com.xc.leetcode.exe_11_22.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Test20 {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.getListNodeByArray(new int[]{1, 3, 5, 7, 9});
        ListNode listNode2 = ListNodeHelper.getListNodeByArray(new int[]{2, 4, 6, 8, 10, 13, 15});
        ListNode merge = Merge1(listNode1, listNode2);
        ListNodeHelper.print(merge);
    }

    //第一种方案：采用递归的形式
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        int value1 = list1.val;
        int value2 = list2.val;
        if (value1 <= value2) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    //第二种方案：采用迭代的形式
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (list1 != null && list2 != null) {
            int value1 = list1.val;
            int value2 = list2.val;
            if (value1 <= value2) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return head.next;
    }

}
