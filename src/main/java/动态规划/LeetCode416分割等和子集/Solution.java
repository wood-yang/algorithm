package 动态规划.LeetCode416分割等和子集;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean b = new Solution().canPartition(nums);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum / 2];
    }
}
