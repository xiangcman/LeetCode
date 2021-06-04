package com.xc.leetcode.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

import java.util.LinkedList;

/**
 * 求链表中倒数第k个结点
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode = ListNodeHelper.initListNode();
        ListNode listNode1 = find(listNode, 3);
        ListNode listNode2 = findByLinkedList(listNode, 3);
        System.out.println("find:" + listNode1.val);
        System.out.println("find:" + listNode2.val);
    }

    /**
     * 双指针的思想
     *
     * @param listNode
     * @param k
     * @return
     */
    private static ListNode find(ListNode listNode, int k) {
        ListNode second = listNode;
        ListNode first = listNode;
        //双指针的思想，让第一个指针先走，走到第k个结点后，第二个指针也跟着走，
        // 当第一个节点走到最后的时候，第二个节点位置就是倒数第k个结点的位置
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }


    /**
     * 利用linkedList来实现查找
     *
     * @param listNode
     * @param k
     * @return
     */
    private static ListNode findByLinkedList(ListNode listNode, int k) {
        LinkedList<ListNode> linkedList = new LinkedList();
        while (listNode != null) {
            linkedList.offerFirst(listNode);
            listNode = listNode.next;
        }

        return (k > 0 && linkedList.size() >= k) ? linkedList.get(k - 1) : null;

    }
}
