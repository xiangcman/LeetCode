package com.xc.leetcode.listnode;

/**
 * 两链表正序相加
 * 例如：1->2->3->4和5->6->7->8相加得到6->8->0->3->1
 */
public class ListNodeAddTwo1 {
    public static void main(String[] args) {
        ListNodeHelper.print(addTwoListNode(ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4}), ListNodeHelper.getListNodeByArray(new int[]{5, 6, 7, 8})));
    }

    public static ListNode addTwoListNode(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }
}
