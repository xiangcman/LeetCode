package com.xc.leetcode.listnode;

/**
 * 链表旋转：从
 * 比如链表是1->2->3->4->5
 * 如果k是2的话，那结果就是4->5->1-2->3
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class ListNodeRotate {
    public static void main(String[] args) {
        ListNode listNode = rotateRight(ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5}), 2);
        ListNodeHelper.print(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        //先算链表的长度
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        //如果n和add相等，说明k是n的整数倍
        int add = n - k % n;
        if (add == n) {//如果add=n，说明k是n的整数倍，也就是刚好旋转的次数是链表长度的整数倍
            //此时实际上正好还是原来的链表
            return head;
        }
        //1->2->3->4->5->1->2->3->4->5...
        iter.next = head;//把头结点的连接到尾结点处
        while (add-- > 0) {//找出要旋转的位置
            iter = iter.next;
        }
        //iter是3，iter.next就是4，所以最后的结果是4->5->1->2->3
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
