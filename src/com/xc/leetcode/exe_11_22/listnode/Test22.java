package com.xc.leetcode.exe_11_22.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729167122&idx=1&sn=7c215fea262f84905e2cebad14f52346&chksm=b830189a8f47918c2a1cb377a8850c79f63e45a19948bef09b92f7894e65ceaa926c4e1109d8#rd
 */
public class Test22 {
    public static void main(String[] args) {
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode listNode = deleteDuplication1(listNodeByArray);
        ListNodeHelper.print(listNode);
    }

    /**
     * 利用linkedhashmap的思路，key存的是listnode中的val值，然后value存的是出现的次数
     * 如果出现大于1次的节点，然后value值等于-1，否则节点的次数等于1
     * 然后遍历linkedhashmap，拿到value等于1的节点
     * 思考：为什么用linkedhashmap，因为它是有序的，因为要保证删除原链表的顺序
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        while (pHead != null) {
            Integer count = linkedHashMap.getOrDefault(pHead.val, 0);
            count++;
            linkedHashMap.put(pHead.val, count);
            pHead = pHead.next;
        }
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        Set<Map.Entry<Integer, Integer>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) {
                listNode.next = new ListNode(key);
                listNode = listNode.next;
            }
        }
        return head.next;
    }

    //采用原地删除的思想
    public static ListNode deleteDuplication1(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
}
