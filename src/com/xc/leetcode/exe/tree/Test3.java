package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的镜像二叉树
 */
public class Test3 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        mirror(init);
        List<List<Integer>> fun = Test1.fun(init);
        System.out.println(Arrays.toString(fun.toArray()));
    }

    public static void mirror(TreeNode treeNode) {
        if (treeNode != null) {
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;
            treeNode.left=right;
            treeNode.right=left;
            mirror(left);
            mirror(right);
        }
    }
}
