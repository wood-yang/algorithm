package 技巧.LeetCode31下一个排列;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new Solution().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int p = nums.length - 1;
        while (p >= 1 && nums[p - 1] >= nums[p]) {
            p--;
        }
        if (p >= 1) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[p - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[p - 1];
                    nums[p - 1] = temp;
                    break;
                }
            }
        }
        reverse(nums, p);
    }

    private void reverse(int[] nums, int p) {
        int left = p;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
