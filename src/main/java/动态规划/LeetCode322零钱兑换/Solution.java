package 动态规划.LeetCode322零钱兑换;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        int amount = scanner.nextInt();
        int ans = new Solution().coinChange(coins, amount);
        System.out.println(ans);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
