package com.xc.leetcode.exe.tree;

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
        //这里和层序遍历的区别是while循环中少了一层queue的size for循环，这里集合定义在外层
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return result;
    }
}
