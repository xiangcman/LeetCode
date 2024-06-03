package com.xc.leetcode.exe.array;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

import java.util.List;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
@Deprecated
public class Test8 {
    public static void main(String[] args) {
        ListNode listNode = rotateRight(ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5}), 2);
        ListNodeHelper.print(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while (fast != null) {
            fast = fast.next;
            length++;
        }
        k = k % length;
        length = 0;
        fast = head;
        while (fast != null && length < k) {
            fast = fast.next;
            length++;
        }
        ListNode pre = null;
        ListNode last = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            last = fast;
            fast = fast.next;
        }
        if (pre != null)
            pre.next = null;
        if (last != null)
            last.next = head;
        return slow;
    }
}
