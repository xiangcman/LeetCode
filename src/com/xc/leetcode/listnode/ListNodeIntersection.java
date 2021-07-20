package com.xc.leetcode.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出链表两个公共部分
 */
public class ListNodeIntersection {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNode listNode2 = ListNodeHelper.getListNodeByArray(new int[]{4, 5});
        ListNode intersectionNode = getIntersectionNode(listNode1, listNode2);
        ListNodeHelper.print(intersectionNode);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        int i = 0;
        while (pA != pB) {
            System.out.println("headA:" + headA.val);
            System.out.println("headB:" + headB.val);
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
            System.out.println(i);
            i++;
        }
        return pA;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        //先把链表A所有的节点加入到set集合中
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        //接着去遍历B链表，依次从set集合中去比较
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
