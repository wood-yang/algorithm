package 图论.LeetCode695岛屿的最大面积;

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
        int ans = new Solution().maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return dfs(grid, r + 1, c) + dfs(grid, r, c + 1) + dfs(grid, r - 1, c) + dfs(grid, r, c - 1);
    }
}
