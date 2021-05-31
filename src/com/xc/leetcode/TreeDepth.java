package com.xc.leetcode;

/**
 * 求二叉树的深度
 */
public class TreeDepth {
    public static void main(String[] args) {

    }

    private static int getDepth(TreeNode root) {
        //如果当前节点为空，说明已经到底了
        if (root == null)
            return 0;
        //递归调用深度左右子树的深度
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        //取左右子树大的深度值
        return left > right ? left + 1 : right + 1;//每次将调用次数加1
    }


}
