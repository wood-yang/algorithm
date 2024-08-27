package 多维动态规划.LeetCode编辑距离;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();
        int ans = new Solution().minDistance(word1, word2);
        System.out.println(ans);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    /*
                    理解两种情况
                    一种是从上从左选一个较小值进行+1，理解为删去当前新增的这个点，还是原本的较小值的情况
                    或者理解为往较小值的情况添加上当前这个点

                    二种是从左上角+1，理解为修改新增的两个点中的一个，使他们相同
                    这里特殊情况就是，当这两个点相同时，不需要增加新的步数
                     */
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
