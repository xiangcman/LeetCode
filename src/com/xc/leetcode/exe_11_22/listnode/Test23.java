package com.xc.leetcode.exe_11_22.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * https://leetcode.cn/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Test23 {
    public static void main(String[] args) {
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{0,1,2});
        ListNode listNode = rotateRight(listNodeByArray, 2);
        ListNodeHelper.print(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            length++;
            last = last.next;
        }
        int lastIndex = length - k % length;
        if (lastIndex == length) {
            //如果k的大小等于length的整数倍，那么旋转后的结果还是它自己
            return head;
        }
        last.next = head;
        while (lastIndex > 0) {
            last = last.next;
            lastIndex--;
        }
        ListNode next = last.next;
        last.next = null;
        return next;
    }
}
