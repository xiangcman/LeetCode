package com.xc.leetcode.treenode;

/**
 * 判断两个二叉树是不是镜像二叉树
 */
public class CheckIsSymmetric {
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
