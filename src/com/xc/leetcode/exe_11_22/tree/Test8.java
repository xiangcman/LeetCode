package com.xc.leetcode.exe_11_22.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

/**
 * 二叉树的深度
 * 每次拿到一个节点后，找这个节点的左节点和右节点的深度，然后取长的深度，然后加上自己的深度1就是最后的深度
 */
public class Test8 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        int length = getLength(init);
        System.out.println("length = " + length);
    }

    public static int getLength(TreeNode treeNode) {
        //每次拿到一个节点后，找这个节点的左节点和右节点的深度，然后取长的深度，然后加上自己的深度1就是最后的深度
        if (treeNode == null) {
            return 0;
        }
        int length1 = getLength(treeNode.left);
        int length2 = getLength(treeNode.right);
        return Math.max(length1, length2) + 1;
    }
}
