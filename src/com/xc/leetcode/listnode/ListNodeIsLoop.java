package com.xc.leetcode.listnode;

/**
 * 判断链表是不是有环
 */
public class ListNodeIsLoop {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.initLoopListNode();
        boolean loop = isLoop(listNode);
        System.out.println("是否有环：" + loop);
    }

    private static boolean isLoop(ListNode listNode) {
        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;//每次跳过两个节点
            slow = slow.next;//跳过一个节点
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
