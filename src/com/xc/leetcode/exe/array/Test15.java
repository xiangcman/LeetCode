package com.xc.leetcode.exe.array;

/**
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * [1,2,3,3,3,3,4,5],3
 * 4
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzA3NTUwNzk0Mw==&mid=2729166686&idx=1&sn=325c780466d4483687001bc83872344d&chksm=b83016d68f479fc05698c09795bf94baf9373d3ede3afad314ba86467b65277a88b6381377ff#rd
 */
public class Test15 {
    //通过二分法，找到index后，然后向index两边去找
    public int GetNumberOfK(int[] array, int k) {
        int index = findIndex(array, k);
        if (index == -1) {
            return 0;
        }
        int count = 1;//如果index不为-1，表示已经找到了一个
        for (int tempIndex = index - 1; tempIndex >= 0; tempIndex--) {
            if (array[tempIndex] == k) {
                count++;
            } else {
                break;
            }
        }
        for (int tempIndex = index + 1; tempIndex < array.length; tempIndex++) {
            if (array[tempIndex] == k) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 二分法查找k在数组中的索引
     *
     * @param array
     * @param k
     * @return
     */
    private int findIndex(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int centerIndex = (left + right) / 2;
            int midle = array[centerIndex];
            if (k == midle) {
                return centerIndex;
            }
            if (k < midle) {//说明在左边
                right = centerIndex - 1;
            } else if (k > midle) {//说明在右边
                left = centerIndex + 1;
            }
        }
        return -1;
    }
}
