package com.xc.leetcode.listnode;

/**
 * 将链表中顺数第k的位置和倒数第k的位置置换
 */
public class ListNodeSwapByK {
    public static void main(String[] args) {
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = swapByK(listNodeByArray, 2);
        ListNodeHelper.print(listNode);
    }

    public static ListNode swapByK(ListNode root, int k) {
        ListNode left = root;
        ListNode right = root;
        for (int i = 0; i < k - 1; i++) {
            left = left.next;//顺数第k个位置的结点
        }
        ListNode cur = left.next;//这里next的原因是要以k为索引开始算第二次递归的节点
        while (cur != null) {
            right = right.next;
            cur = cur.next;
        }
        //互换值是否合适
        int temp = right.val;
        right.val = left.val;
        left.val = temp;
        return root;
    }
}
