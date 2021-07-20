package com.xc.leetcode.listnode;

/**
 * 从m到n的位置反转链表
 * 反转从位置 m 到 n 的链表。
 * 示例：
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ListNodeRevertFromMtoN {
    public static void main(String[] args) {
        ListNode listNodeByArray = ListNodeHelper.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        ListNode test = reverseBetween(listNodeByArray, 2, 4);
        ListNodeHelper.print(test);
    }

    private static ListNode test(ListNode listNode, int m, int n) {
        int index = 1;
        ListNode newListNode = new ListNode(-1);
        ListNode temp = newListNode;
        ListNode firstNode = new ListNode(-1);
        ListNode temp1 = firstNode;
        ListNode lastNode = new ListNode(-1);
        ListNode temp2 = lastNode;
        ListNode firstLastNode = null;
        while (listNode != null) {
            if (index >= m && index <= n) {
                ListNode listNode1 = new ListNode(listNode.val);
                temp.next = listNode1;
                temp = listNode1;
            }
            if (index < m) {
                ListNode ln = new ListNode(listNode.val);
                temp1.next = ln;
                temp1 = ln;
                if (index == m - 1) {
                    firstLastNode = ln;
                }
            }
            if (index > n) {
                ListNode listNode1 = new ListNode(listNode.val);
                temp2.next = listNode1;
                temp2 = listNode1;
            }
            listNode = listNode.next;
            index++;
        }
        firstLastNode.next = revert(newListNode.next);
        newListNode.next.next = lastNode.next;
        return firstNode.next;
    }

    private static ListNode revert(ListNode root) {
        ListNode pre = null;
        ListNode next = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

    //以下是官方的解法
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {//1-2-3-4-5
            pre = pre.next;//比如left是2，则需要拿到1这个结点，也就是虚拟节点的next结点
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;//先取出对应的节点，下面把相应的节点置为null
        ListNode curr = rightNode.next;

        // 注意：切断链接，把中间的部分取出来，然后才进行翻转
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        //这里没有返回链表，其实不需要知道返回的链表，只要把链表接上就ok
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;//先把前半部分接上，这里为什么是rightNode呢，因为反转后，rightNode节点其实就是反转后的头节点
        leftNode.next = curr;//接着把后半部分接上，反转后leftNode节点就是反转后的尾结点了
        return dummyNode.next;//最后返回虚拟节点的next位置就是我们最后的链表
    }

    private static void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNodeHelper.print(head);
    }

}
