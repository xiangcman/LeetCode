package com.xc.leetcode.listnode;

/**
 * 从m到n的位置反转链表
 * 反转从位置 m 到 n 的链表。
 * 示例：
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ListNodeRevertFromMtoN {
    public static void main(String[] args) {
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNode test = test(listNodeByArray, 2, 4);
        ListNodeHelper.print(test);
    }

    private static ListNode test(ListNode listNode, int m, int n) {
        int index = 1;
        ListNode newListNode = new ListNode(-1);
        ListNode temp = newListNode;
        ListNode firstNode = new ListNode(-1);
        ListNode temp1 = firstNode;
        ListNode lastNode = new ListNode(-1);
        ListNode temp2 = lastNode;
        ListNode firstLastNode = null;
        while (listNode != null) {
            if (index >= m && index <= n) {
                ListNode listNode1 = new ListNode(listNode.val);
                temp.next = listNode1;
                temp = listNode1;
            }
            if (index < m) {
                ListNode ln = new ListNode(listNode.val);
                temp1.next = ln;
                temp1 = ln;
                if (index == m - 1) {
                    firstLastNode = ln;
                }
            }
            if (index > n) {
                ListNode listNode1 = new ListNode(listNode.val);
                temp2.next = listNode1;
                temp2 = listNode1;
            }
            listNode = listNode.next;
            index++;
        }
        firstLastNode.next = revert(newListNode.next);
        newListNode.next.next = lastNode.next;
        return firstNode.next;
    }

    private static ListNode revert(ListNode root) {
        ListNode pre = null;
        ListNode next = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

}
