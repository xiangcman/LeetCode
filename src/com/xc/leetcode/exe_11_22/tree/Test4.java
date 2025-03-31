package com.xc.leetcode.exe_11_22.tree;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

import java.util.*;

/**
 * 二叉树从上到下打印
 */
public class Test4 {
    public static void main(String[] args) {
        TreeNode init = TreeNodeHelper.init();
        List<Integer> fun = fun(init);
        System.out.println(Arrays.toString(fun.toArray()));
    }

    public static List<Integer> fun(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                break;
            }
            result.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return result;
    }
}
