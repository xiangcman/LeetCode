package com.xc.leetcode.exe.array;

import com.xc.leetcode.treenode.TreeNode;
import com.xc.leetcode.treenode.TreeNodeHelper;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
@Deprecated
public class Test9 {
    public static void main(String[] args) {
        List<List<Integer>> lists = levelOrder(TreeNodeHelper.init());
        String s = Arrays.toString(lists.toArray());
        System.out.println("s = " + s);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelData = new ArrayList<>();
            int size = queue.size();//这里先要取size，因为在for里面offer之后size又变了
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                levelData.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(levelData);
        }
        return result;
    }
}
