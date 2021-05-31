package com.xc.leetcode;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumInArray {
    public boolean Find(int target, int[][] array) {
        int row = 0;
        int column = array[0].length - 1;//比如先确定一个基准的位置，该基准位置是第一行的最后一个，也就是右上角
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            //如果发现当前数比要找的数要大，则往前一列找

            if (array[row][column] > target) {
                column--;
            } else {
                //如果发现当前数比要找的数要小的话，则往下面一行找
                row++;
            }
        }
        return false;
    }
}
