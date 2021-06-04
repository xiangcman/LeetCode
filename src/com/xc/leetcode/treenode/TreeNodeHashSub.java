package com.xc.leetcode.treenode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构
 */
public class TreeNodeHashSub {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //如果两个树都不为空才会走这里
        if (root2 != null && root1 != null) {
            //如果根的值相等
            if (root1.val == root2.val) {
                //找左右子树是否相等
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果上面分析的结果是不相等，继续判断A树左节点和B树或A右节点和B树
            if (!result)
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果右边的树为空直接说明相等
        if (node2 == null) {
            return true;
        }
        //如果左边的树为空直接返回不相等，说明不包含
        if (node1 == null) {
            return false;
        }
        //如果两个值也不相等，说明也是不相等的
        if (node1.val != node2.val) {
            return false;
        }
        //继续递归调用对应的左右子树
        return doesTree1HaveTree2(node1.left, node2.left) &&
                doesTree1HaveTree2(node1.right, node2.right);
    }
}
