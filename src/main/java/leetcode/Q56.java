package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author drone
 * @date 2021/5/24
 */
public class Q56 {
    public int[][] merge(int[][] intervals) {
        if (null == intervals || 0 == intervals.length) {
            return new int[0][0];
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }

        });

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];

            //merged中最后一个区间的右边界小于当前区间的左边界  2个区间不重合
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                //区间重合 选择较大的数作为新的右区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
