package com.xc.leetcode.treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历:先是左结点，然后当前结点，然后是右结点
             *   1
             * /  \
          *   2    3
          *  / \  / \
          * 4  5 6  7
 *
 * 输出：[4,2,5,1,6,3,7]
 **/
public class TreeZhong {
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
            result.add(treeNode.val);
            result.addAll(fun1(treeNode.right));
        }
        return result;
    }

    //迭代的形式
    static List<Integer> fun2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            //循环将左子树都添加到栈内
            //弹出最后一个左子树
            //将这个左子树的值添加到list中，
            //如果这个左子树右子树不为空，则添加到栈中
            //重复上述操作
            while (root != null) {
                stack.push(root);
                root = root.left;
            }//上面添加完后是4，2，1
            //接着对每一个节点的右节点进行迭代
            TreeNode node = stack.pop();
            //第一先取到4，然后4的右节点为空；接着是2这个结点，而2这个结点的右节点是5，因此拿到5后，加入到链表中，所以5会插入到2和1中间，
            //接着拿到1，它的右结点是3，然后把3放到链表首位，接着把3的左结点6也放到链表首位，然后才取到6放到集合中，而6没有右节点，所以直接找到刚才的3这个结点，
            // 而3这个结点的右节点是7，因此直接遍历到7这个节点
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

}
