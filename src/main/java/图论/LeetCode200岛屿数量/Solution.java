package 图论.LeetCode200岛屿数量;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                char c = scanner.next().charAt(0);
                grid[i][j] = c;
            }
        }
        int i = new Solution().numIslands(grid);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
