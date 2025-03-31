package com.xc.leetcode.exe_11_22.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class Test1 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<List<Integer>> fun = fun(init);
        System.out.println(Arrays.toString(fun.toArray()));
    }

    public static List<List<Integer>> fun(TreeNode treeNode) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        treeNodes.offer(treeNode);//offer是给尾部插入节点
        while (!treeNodes.isEmpty()) {
            int length = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode root = treeNodes.poll();//poll是从头部取出节点
                if (root == null) {
                    break;
                }
                list.add(root.val);
                TreeNode left = root.left;
                TreeNode right = root.right;
                if (left != null) {
                    treeNodes.offer(left);
                }
                if (right != null) {
                    treeNodes.offer(right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
