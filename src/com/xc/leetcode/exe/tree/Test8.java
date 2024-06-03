package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

/**
 * 二叉树的深度
 */
public class Test8 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        int fun = fun(init);
        System.out.println("fun = " + fun);
    }

    public static int fun(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDeep = fun(treeNode.left);
        int rightDeep = fun(treeNode.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
