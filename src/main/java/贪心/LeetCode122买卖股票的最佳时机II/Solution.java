package 贪心.LeetCode122买卖股票的最佳时机II;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int ans = new Solution().maxProfit(prices);
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
