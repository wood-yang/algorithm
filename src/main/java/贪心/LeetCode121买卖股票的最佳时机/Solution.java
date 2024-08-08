package 贪心.LeetCode121买卖股票的最佳时机;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int i = new Solution().maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans, prices[i] - minPrice);
        }
        return ans;
    }
}
