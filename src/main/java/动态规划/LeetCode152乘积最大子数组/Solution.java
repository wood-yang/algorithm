package 动态规划.LeetCode152乘积最大子数组;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().maxProduct(nums);
        System.out.println(ans);
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = max;
            int mn = min;
            max = Math.max(nums[i] * mn, Math.max(nums[i], nums[i] * mx));
            min = Math.min(nums[i] * mn, Math.min(nums[i], nums[i] * mx));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
