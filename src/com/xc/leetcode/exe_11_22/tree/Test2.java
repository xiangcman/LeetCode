package com.xc.leetcode.exe_11_22.tree;

import com.xc.leetcode.treenode.TreeNode;

/**
 * 判断树2是不是树1的子树
 */
public class Test2 {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean isChildTree = false;
        //首先要求两个树不为空
        if (root1 != null && root2 != null) {
            //如果两个树的内容相等，然后比较两个树的子节点
            if (root1.val == root2.val) {
                isChildTree = isSameTree(root1, root2);
            }
            //如果不是子树,还得来一遍子树的比较
            if (!isChildTree) {
                isChildTree = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return isChildTree;
    }

    private static boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null) {
            return false;
        }
        if (tree2 == null) {
            return true;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        //比较剩余的
        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }
}
