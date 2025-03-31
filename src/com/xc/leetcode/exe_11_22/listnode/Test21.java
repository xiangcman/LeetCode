package com.xc.leetcode.exe_11_22.listnode;

import com.xc.leetcode.listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729166676&idx=1&sn=3c74df58c2172ea56e6526f4f40cd9e7&chksm=b83016dc8f479fca3ee1f931a7a4cba132163aa0c24e3b47cc880a99869122ba31ebcf3229d8#rd
 */
public class Test21 {
    public static void main(String[] args) {

    }

    //先把链表1的节点都放到set集合中，然后遍历链表2
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    //链表差值法
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode listNode1 = pHead1;
        ListNode listNode2 = pHead2;
        int length1 = 0;
        int length2 = 0;
        while (listNode1 != null) {
            length1++;
            listNode1 = listNode1.next;
        }
        while (listNode2 != null) {
            length2++;
            listNode2 = listNode2.next;
        }
        int step = length1 - length2;
        if (step > 0) {//如果链表1的长度大于链表2，则让链表1先走step步
            while (step > 0) {
                pHead1 = pHead1.next;
                step--;
            }
        } else {//如果链表2的长度大于链表1，则让链表2先走step步
            while (step < 0) {
                pHead2 = pHead2.next;
                step++;
            }
        }
        //最后两个同时走
        while (pHead1 != null && pHead2 != null) {
            //如果链表1中的节点和链表2中的节点相等则返回节点
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
