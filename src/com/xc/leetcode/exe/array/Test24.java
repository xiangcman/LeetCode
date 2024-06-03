package com.xc.leetcode.exe.array;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150
 */
public class Test24 {
    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            String s = Arrays.toString(ints);
            System.out.println("result:" + s);
        }
    }

    //思路：
    // 1.先将数组中的区间以第一个元素按照小到大排序
    //2.接着看当前merge后的数组中的最后一个区间的右端点是否比当前的区间的左端点要大，如果大的话，说明有区间的重叠，那么此时就需要和当前区间的右端点进行比较，然后取大值，然后更新merge的最后一个区间的右端点
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        List<int[]> merge = new ArrayList<>();
        //按每一个区间的左边的值排序，接着遍历区间，如果该区间的left比最后一个区间的右边要大，那说明没有合并，此时需要创建一个新的添加到集合中
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int left = interval[0];
            int right = interval[1];
            //如果当前区间的left比最后一个区间的right还要大，则说明没有交集，需要新创建一个区间
            if (i == 0 || left > merge.get(merge.size() - 1)[1]) {
                merge.add(new int[]{left, right});
            } else {//取最后一个区间的right和当前区间的right最大值，然后给最后一个区间的right设置该最大值
                int lastRight = merge.get(merge.size() - 1)[1];
                merge.get(merge.size() - 1)[1] = Math.max(right, lastRight);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
