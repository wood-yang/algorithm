package 图论.LeetCode994腐烂的橘子;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int i = new Solution().orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> list = new LinkedList<>();
        int ans = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
            }
        }
        while (!list.isEmpty()) {
            ans++;
            int n = list.size();
            for (int i = 0; i < n; i++) {
                int[] ints = list.removeFirst();

                int[] rr = new int[]{1, -1, 0, 0};
                int[] cc = new int[]{0, 0, 1, -1};
                for (int j = 0; j < 4; j++) {
                    int r = ints[0] + rr[j];
                    int c = ints[1] + cc[j];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        list.add(new int[]{r, c});
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(ans, 0);
    }
}
