package com.xc.leetcode.listnode;

/**
 * 删除链表中倒数第k个结点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = removeNthFromEnd(ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5}), 2);
        ListNodeHelper.print(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        //先让第一个指针先走，走到n这个位置
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        //然后让第二个指针也跟着走，第一个指针走到尾后，第二个指针就是倒数第n的位置
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //将倒数n的next的next结点指向倒数n的next结点
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

}
