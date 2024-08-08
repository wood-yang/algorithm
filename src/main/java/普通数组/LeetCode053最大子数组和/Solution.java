package 普通数组.LeetCode053最大子数组和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int ans = new Solution().maxSubArray(nums);
        System.out.println(ans);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        //dp数组的含义是 dp[i]是以nums[i]为结尾的子数组的和的最大值
        int[] dp = new int[n];
        int ans;
        ans = dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            //状态转移方程
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            }
            else {
                dp[i] = dp[i - 1] + nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
