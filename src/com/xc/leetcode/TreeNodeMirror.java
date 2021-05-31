package com.xc.leetcode;

/**
 * 求二叉树的镜像二叉树
 */
public class TreeNodeMirror {
    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            //左右子树进行交换结构
            TreeNode temp = left;
            root.left = right;
            root.right = temp;
            //然后递归调用调用左右子树它下面的节点交换
            Mirror(left);
            Mirror(right);
        }
    }
}
