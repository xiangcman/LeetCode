package com.xc.leetcode.exe.listnode;

import com.xc.leetcode.listnode.ListNode;
import com.xc.leetcode.listnode.ListNodeHelper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729167122&idx=1&sn=7c215fea262f84905e2cebad14f52346&chksm=b830189a8f47918c2a1cb377a8850c79f63e45a19948bef09b92f7894e65ceaa926c4e1109d8#rd
 */
public class Test22 {
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
        //因为linkedhashmap是有序的，我们存入的节点要保证顺序
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        while (pHead != null) {
            if (!map.containsKey(pHead.val)) {
                map.put(pHead.val, 1);//如果不存在多次的，则给value赋为1
            } else {
                map.put(pHead.val, -1);
            }
            pHead = pHead.next;
        }
        ListNode listNode = new ListNode(-1);
        ListNode temp = listNode;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value == 1) {
                temp.next = new ListNode(integerIntegerEntry.getKey());
                temp = temp.next;
            }
        }
        return listNode.next;
    }

    /**
     * 原地删除的思想，直接把结点删除
     * 检测到有相同的元素，则把相同元素的前一个结点的next赋为相同元素的后一个结点
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication1(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while (cur != null) {
            //如果当前结点的val和当前节点的下一个点的val相等的话，那么就需要删除重复的节点
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;//-1->
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public static ListNode deleteDuplication2(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        // 上一个元素指针为pre
        ListNode pre = head, cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
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
        return head.next;
    }


    public static void main(String[] args) {
//        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{1, 1, 1, 2, 3});
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 3, 4, 5});
        ListNode listNode = deleteDuplication1(listNodeByArray);
        ListNodeHelper.print(listNode);
    }
}
