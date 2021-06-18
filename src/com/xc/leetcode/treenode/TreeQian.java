package com.xc.leetcode.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历:先是当前结点，然后左结点，然后是右结点
 */
public class TreeQian {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<Integer> list = fun2(init);
        System.out.println(list);
    }

    //递归的形式
    static List<Integer> fun1(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode != null) {
            result.add(treeNode.val);
            result.addAll(fun1(treeNode.left));
            result.addAll(fun1(treeNode.right));
        }
        return result;
    }

    //迭代的形式
    static List<Integer> fun2(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(treeNode);//push是放到链表的头部
        while (!treeNodes.isEmpty()) {
            treeNode = treeNodes.pop();//取链表的头部
            result.add(treeNode.val);
            if (treeNode.right != null) {
                treeNodes.push(treeNode.right);//先把右结点放到链表的头部
            }
            if (treeNode.left != null) {
                treeNodes.push(treeNode.left);//然后把左结点压到上面刚放的右节点前面，下次在取的时候就能先取到左边的结点
            }
        }
        return result;
    }

}
