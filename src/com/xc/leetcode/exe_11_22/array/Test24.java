package com.xc.leetcode.exe_11_22.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merges = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            int left = current[0];
            int right = current[1];
            //第一个数组或者是数组中的左区间大于集合中最后一个元素的右区间，则往集合中添加一个新的数组
            if (i == 0 || left > merges.get(merges.size() - 1)[1]) {
                merges.add(new int[]{left, right});
            } else {
                //否则将最后一个元素的右区间更新为当前区间的右区间和集合中最后一个区间的右区间的最大值
                int[] lastItem = merges.get(merges.size() - 1);
                lastItem[1] = Math.max(lastItem[1], right);
            }
        }
        return merges.toArray(new int[merges.size()][]);
    }
}
