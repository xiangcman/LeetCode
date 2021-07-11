package com.xc.leetcode;

import apple.laf.JRSUIUtils;
import com.xc.leetcode.treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeZhong {
    List<Integer> test(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        final LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            //先把所有的左边的结点添加进去
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            root = root.right;
        }
        return list;
    }
}
