package com.xc.leetcode.treenode;

/**
 * 求二叉树的深度
 */
public class TreeDepth {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        int depth = getDepth(init);
        System.out.println("depth = " + depth);
    }

    private static int getDepth(TreeNode root) {
        //如果当前节点为空，说明已经到底了
        if (root == null)
            return 0;
        System.out.println("root.val = " + root.val);
        //递归调用深度左右子树的深度
        int left = getDepth(root.left);
        int right = getDepth(root.right);
//        System.out.println("getDepth left:"+left);
//        System.out.println("getDepth right:"+right);
        //取左右子树大的深度值
        return Math.max(left,right)+1;
//        return left > right ? left + 1 : right + 1;//每次将调用次数加1
    }


}
