package com.xc.leetcode.exe.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class Test1 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<List<Integer>> fun = fun(init);
        System.out.println(Arrays.toString(fun.toArray()));
    }

    public static List<List<Integer>> fun(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();//双端链表，主要用到先插入先取出的特点
        treeNodes.offer(treeNode);
        while (!treeNodes.isEmpty()) {
            List<Integer> ceng = new ArrayList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = treeNodes.poll();//poll是从双端链表的头部取出元素
                ceng.add(poll.val);
                if (poll.left != null) {
                    //先放入左节点
                    treeNodes.offer(poll.left);//offer是放到双端链表的尾部
                }
                if (poll.right != null) {
                    //再放入右节点
                    treeNodes.offer(poll.right);
                }
            }
            result.add(ceng);
        }
        return result;
    }
}
