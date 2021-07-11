package com.xc.leetcode.treenode;

/**
 * 判断二叉树是不是平衡二叉树，平衡二叉树每个节点的左右两个子树的高度差的绝对值不超过1
 */
public class CheckIsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
