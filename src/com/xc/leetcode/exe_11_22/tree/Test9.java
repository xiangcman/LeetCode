package com.xc.leetcode.exe_11_22.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

/**
 * 求二叉树的最长路径
 * 这个和上一个算法题类似，上一个是算二叉树的最长深度，路径其实算「最长的左节点+最长的右节点+加根节点」
 */
public class Test9 {

    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        int fun = fun(init);
        System.out.println("fun = " + fun);
    }

    public static int fun(TreeNode treeNode) {
        int length = getLength(treeNode.left);
        int length1 = getLength(treeNode.right);
        return length1 + length + 1;
    }


    private static int getLength(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftLength = getLength(treeNode.left);
        int rightLength = getLength(treeNode.right);
        return Math.max(leftLength, rightLength) + 1;
    }


}
