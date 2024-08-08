package 普通数组.LeetCode41缺失的第一个正数;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().firstMissingPositive(nums);
        System.out.println(ans);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {
                nums[a++] = nums[i];
            }
        }
        for (int i = a; i < n; i++) {
            nums[i] = n + 1;
        }
        for (int i = 0; i < a; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
