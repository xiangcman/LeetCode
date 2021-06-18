package com.xc.leetcode.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历:先是左结点，然后是右结点，然后才是当前结点
 */
public class TreeHou {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<Integer> list = fun2(init);
        System.out.println(list);
    }

    //递归的形式
    static List<Integer> fun1(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode != null) {
            result.addAll(fun1(treeNode.left));
            result.addAll(fun1(treeNode.right));
            result.add(treeNode.val);
        }
        return result;
    }

    //迭代的形式
    static List<Integer> fun2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //后序遍历 left right root
            //root right left
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return list;
    }

}
