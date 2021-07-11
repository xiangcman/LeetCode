package com.xc.leetcode.treenode;

import com.xc.leetcode.listnode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历，每遍历一层，放到集合里面，所以最终是个双层的集合
 */
public class TreeNodelevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        //这里定义成queue主要是用到了双链表的特性
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//offer是放到队列的后面
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();//poll是取链表的第一位置
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);//offer是把节点加入到队列的后面
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
