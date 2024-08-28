package 普通数组.LeetCode056合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        int[][] merge = new Solution().merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int min = intervals[i][0];
            int max = intervals[i][1];
            // while 非常巧妙，一直维护到不能涵盖，否则我就利滚利滚利，嘎嘎合取
            while (i + 1 < n && max >= intervals[i + 1][0]) {
                max = Math.max(max, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{min, max});
        }

        return list.toArray(new int[][]{});
    }
}
