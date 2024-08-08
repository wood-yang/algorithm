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
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int n = intervals.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            int l = i;
            if (max >= intervals[i][1]) {
                continue;
            }
            max = intervals[i][1];
            while (i + 1 < n && max >= intervals[i + 1][0]) {
                max = Math.max(max, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{intervals[l][0], max});
        }

        return list.toArray(new int[][]{});
    }
}
