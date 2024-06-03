package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;

/**
 * 判断root2树是不是root1树的子树
 */
public class Test2 {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //如果两者都不为空才比较
            if (root1.val == root2.val) {
                //再来比较剩下的
                result = hasSame(root1, root2);
            }
            if (!result) {
                //再来比较子节点
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean hasSame(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return hasSame(root1.left, root2.left) && hasSame(root1.right, root2.right);
    }
}
