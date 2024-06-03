package com.xc.leetcode.exe.listnode;

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
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{0, 1, 2});
        ListNode listNode = rotateRight(listNodeByArray, 4);
        ListNodeHelper.print(listNode);
    }

    /**
     * 思路：
     * 首先算链表的长度n
     * 由于k有可能比n大，因此我们求倒数k的节点时候用k%n的索引
     * 那顺数顺序是n-k%n的顺序，那前面一个结点是n-1-k%n，并且旋转后n-1-k%n这个结点的next=null，例如例一中的数字3
     * 可以先将链表构成环，然后将n-1-k%n与它后面的节点给切断，就是最后旋转的结果
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        //第一步求长度
        ListNode last = head;
        int n = 1;
        while (last.next != null) {
            last = last.next;
            n++;
        }
        int newLast = n - 1 - k % n;//找到要切断的点
        last.next = head;//构成了环
        while (newLast >= 0) {
            last = last.next;
            newLast--;
        }
        ListNode result = last.next;
        last.next = null;//找到切断的那个点
        return result;
    }
}
