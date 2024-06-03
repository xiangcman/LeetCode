package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的后序遍历， 左 右 根
 */
public class Test7 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<Integer> fun = fun(init);
        System.out.println(Arrays.toString(fun.toArray()));
    }

    public static List<Integer> fun(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        print(treeNode, result);
        return result;
    }

    public static void print(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        print(treeNode.left, result);
        print(treeNode.right, result);
        result.add(treeNode.val);
    }
}