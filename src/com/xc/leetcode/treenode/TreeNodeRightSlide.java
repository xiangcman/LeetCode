package com.xc.leetcode.treenode;

import com.xc.leetcode.listnode.ListNodeHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 找出二叉树每层最右边的节点
 */
public class TreeNodeRightSlide {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<Integer> list = rightSlideView(init);
        System.out.println("list = " + list);
    }

    public static List<Integer> rightSlideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1)
                    list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);//先添加左边的
                if (node.right != null)
                    queue.offer(node.right);//最后添加右边的，所以在取的时候右边的节点在链表的后面
            }
        }
        return list;
    }
}
