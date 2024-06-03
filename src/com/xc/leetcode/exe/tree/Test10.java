package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

/**
 * 判断二叉树是不是对称二叉树
 * 其实思路就是从根节点，把二叉树分成两个，然后判断这两个树是不是镜像就行
 */
public class Test10 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init3();
        boolean fun = fun(init);

//        TreeNode init2 = TreeNodeHelper.init2();
//        boolean mirror = isMirror(init, init2);
        System.out.println("fun = " + fun);
    }

    public static boolean fun(TreeNode treeNode) {
        return isMirror(treeNode.left, treeNode.right);
    }

    public static boolean isMirror(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        //用递归判断两个树的左结点和右节点是否互相相等，才算是镜像二叉树
        return isMirror(treeNode1.left, treeNode2.right) && isMirror(treeNode1.right, treeNode2.left);
    }
}
