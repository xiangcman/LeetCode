package com.xc.leetcode.treenode;

import java.util.Arrays;

/**
 * 根据二叉树的中序遍历、和后续遍历求出二叉树结构。
 * <p>
 * 前序遍历是从父节点到左节点，再到右节点
 * 中序遍历是左结点到根结点再到右结点
 */
public class ReConstructBinaryTree1 {
    /**
     * pre中序的结果:左根右
     * in后续的结果:左右根
     * pre:{1,2,4,7,3,5,6,8}
     * in:{4,7,2,1,5,3,8,6}
     *
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //获取到根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        //把前序遍历左边的给到下一次遍历的前序遍历的数组    //把中序遍历的左边给到下一次遍历的中序遍历的数组
                        Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(
                        //把前序遍历的右边给到下一次遍历的前序遍历的数组        //把中序遍历的右边给到下一次遍历的中序遍历的数组
                        Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}
