package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

/**
 * 求二叉树最长路径
 */
public class Test9 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        int fun = fun(init);
        System.out.println("fun = " + fun);
    }

    //最长路径可以理解为左节点的深度+右节点的深度+1（根节点算一个路径长度）
    public static int fun(TreeNode treeNode) {
        int leftDeep = getDeep(treeNode.left);
        int rightDeep = getDeep(treeNode.right);
        return leftDeep + rightDeep + 1;
    }

    public static int getDeep(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDeep = getDeep(treeNode.left);
        int rightDeep = getDeep(treeNode.right);
        return Math.max(leftDeep, rightDeep) + 1;
    }
}
