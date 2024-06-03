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
        ListNode listNode3 = find1(listNode, 3);
        System.out.println("find:" + listNode1.val);
        System.out.println("find:" + listNode2.val);
        System.out.println("find:" + listNode3.val);
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
        // 当第一个指针走到最后的时候，此时第二个指针的位置就是倒数第k个结点的位置
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
     * 利用linkedList来实现查找,其实跟栈有点像
     *
     * @param listNode
     * @param k
     * @return
     */
    private static ListNode findByLinkedList(ListNode listNode, int k) {
        LinkedList<ListNode> linkedList = new LinkedList();
        while (listNode != null) {
            linkedList.offerFirst(listNode);//每次把当前节点放到最前面，这样的话最前面的是链表中最后面的节点
            listNode = listNode.next;
        }

        return (k > 0 && linkedList.size() >= k) ? linkedList.get(k - 1) : null;

    }

    private static ListNode find1(ListNode listNode, int k) {
        int length = 0;
        ListNode temp = listNode;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int i = length - k;//i=8
        while (i >0) {
            listNode = listNode.next;
            i--;
        }
        return listNode;
    }
}
