package com.xc.leetcode.treenode;

public class TreeNodeHelper {
    public static TreeNode init() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
//        treeNode4.left = treeNode8;
        return treeNode1;
    }

    public static TreeNode init2() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode6;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode4;
//        treeNode4.left = treeNode8;
        return treeNode1;
    }

    public static TreeNode init3() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode6;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode4;
//        treeNode4.left = treeNode8;
        return treeNode1;
    }
}
