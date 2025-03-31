package com.xc.leetcode.exe.array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729165659&idx=1&sn=7272e605ec9f2fa340deffb56536d914&chksm=b83012d38f479bc5607f124059d2f48233f41b6950956ceb42207e8bad59f3fb5cf991e9495f#rd
 */
public class Test12 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int top = 0;
        int right = matrix[0].length;//有边界定义为第一行的最后一列
        int down = matrix.length;//down定义为行数
        while (true) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);//第一排打印完了
            }
            top++;
            if (top > down) {
                break;
            }
            //接着右边的一列
            for (int i = top; i < down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(right<left){
                break;
            }
            //接着最底下的一行
            for (int i=right;i>=left;i--){
                result.add(matrix[down][i]);
            }
            down--;
            if(down<top){
                break;
            }
            //左边的一列
            for (int i=down;i>=top;i--){
                result.add(matrix[i][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return result;
    }
}
