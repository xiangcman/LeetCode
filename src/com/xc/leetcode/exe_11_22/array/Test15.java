package com.xc.leetcode.exe_11_22.array;


/**
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * [1,2,3,3,3,3,4,5],3
 * 4
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729166686&idx=1&sn=325c780466d4483687001bc83872344d&chksm=b83016d68f479fc05698c09795bf94baf9373d3ede3afad314ba86467b65277a88b6381377ff#rd
 */
public class Test15 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        int i = GetNumberOfK(array, 3);
        System.out.println("i = " + i);
    }

    //先通过二分法查找到该数的索引，然后向两边去找
    public static int GetNumberOfK(int[] array, int k) {
        int index = findIndex(array, k);
        if (index == -1) {
            return 0;
        }
        int count = 1;
        for (int i = index-1; i >=0; i--) {
            if (array[i] == k) {
                count++;
            }else{
                break;
            }
        }
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    private static int findIndex(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int centerIndex = (left + right) / 2;
            int middle = array[centerIndex];
            if (k == middle) {
                return centerIndex;
            } else if (k > middle) {
                //如果中间的数小于k，则说明要往右边找
                left = centerIndex + 1;
            } else {
                right = centerIndex - 1;
            }
        }
        return -1;
    }

}
