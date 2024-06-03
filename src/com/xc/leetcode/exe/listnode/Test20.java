package com.xc.leetcode.exe.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Test20 {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeHelper.getListNodeByArray(new int[]{1, 3, 5, 7, 9});
        ListNode listNode2 = ListNodeHelper.getListNodeByArray(new int[]{2, 4, 6, 8, 10,13,15});
        ListNode merge = merge2(listNode1, listNode2);
        ListNodeHelper.print(merge);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static ListNode merge2(ListNode list1, ListNode list2){
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                temp.next=new ListNode(list1.val);
                list1=list1.next;
            }else{
                temp.next=new ListNode(list2.val);
                list2=list2.next;
            }
            temp=temp.next;
        }
        temp.next=list1!=null?list1:list2;
        return head.next;
    }
}
