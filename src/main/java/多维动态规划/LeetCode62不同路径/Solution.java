package 多维动态规划.LeetCode62不同路径;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int ans = new Solution().uniquePaths(m, n);
        System.out.println(ans);
    }

//    /**
//     * 动态规划
//     * @param m
//     * @param n
//     * @return
//     */
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = 1;
//                }
//                else {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    /**
     * 组合
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        long ans = 1L;
        int a = n;
        int b = 1;
        for (int i = 1; i <= m - 1; i++) {
            ans = ans * a / b;
            a++;
            b++;
        }
        return (int) ans;
    }
}
