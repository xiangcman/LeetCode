package com.xc.leetcode.exe.listnode;


import com.xc.leetcode.listnode.ListNode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729166676&idx=1&sn=3c74df58c2172ea56e6526f4f40cd9e7&chksm=b83016dc8f479fca3ee1f931a7a4cba132163aa0c24e3b47cc880a99869122ba31ebcf3229d8#rd
 */
public class Test21 {
    /**
     * 通过用set集合判断节点是否在集合中
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
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

    /**
     * 链表移动差值法
     * 两个链表，看谁长，然后求出两者的长度差值，然后让长的先走，这样两者顺序遍历就能看有没有相交的点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        //如果有任何一个是空的，那么就不用比较了
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode listNode1 = pHead1;
        ListNode listNode2 = pHead2;
        int p1length = 0;
        int p2length = 0;
        while (listNode1 != null) {
            p1length++;
            listNode1 = listNode1.next;
        }
        while (listNode2 != null) {
            p2length++;
            listNode2 = listNode2.next;
        }
        int step = p1length - p2length;
        if (step > 0) {
            // 链表1更长，链表1移动
            while (step != 0) {
                pHead1 = pHead1.next;
                step--;
            }
        } else {
            // 链表2更长，链表2移动
            while (step != 0) {
                pHead2 = pHead2.next;
                step++;
            }
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 链表拼接法
     * 这种方案是将链表一pHead1拼上pHead2，将链表二pHead2拼上pHead1，然后由于两个链表的长度相等，依次遍历，直到找到两个相等的节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        while (pHead1 != pHead2) {
            pHead1 = pHead1 != null ? pHead1.next : pHead2;
            pHead2 = pHead2 != null ? pHead2.next : pHead1;
        }
        return pHead1;
    }
}
