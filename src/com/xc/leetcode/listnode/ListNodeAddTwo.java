package com.xc.leetcode.listnode;

/**
 * 两个链表相加，从末尾开始相加，最终得到一个链表
 * 1->2->3->4  4->5->9  两个链表，从末尾开始相加 ，得到的链表结果是:1->6->9->3，手写这到算法题？
 */
public class ListNodeAddTwo {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4});
        ListNodeHelper.print(listNode1);
        ListNode listNode2 = ListNodeHelper.getListNodeByArray(new int[]{4, 5, 9});
        ListNodeHelper.print(listNode2);
        ListNode addListNode = addTwoNumbers(listNode1, listNode2);
        ListNodeHelper.print(addListNode);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = revert(l1);
        l2 = revert(l2);
        ListNode v1 = l1, v2 = l2;
        int carry = 0;
        ListNode pre = null;
        while (v1 != null || v2 != null) {
            int x = (v1 == null) ? 0 : v1.val;   //如果节点不为空，获取值
            int y = (v2 == null) ? 0 : v2.val;
            int sum = x + y + carry;   //计算当前值
            carry = sum / 10;  //计算进位
            ListNode current = new ListNode(sum % 10);  //计算出结果中，当前位数的数值。
            current.next = pre;
            pre = current;
            if (v1 != null) v1 = v1.next;
            if (v2 != null) v2 = v2.next;
        }
        if (carry > 0) { //判断进位是否为0，不为0则添加末尾节点。
            ListNode first = new ListNode(carry);
            first.next = pre;
            return first;
        }
        return pre;
    }

    private static ListNode revert(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
