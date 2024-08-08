package 双指针.LeetCode283移动零;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new Solution().moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[c++] = nums[i];
            }
        }
        for (int i = c; i < n; i++) {
            nums[i] = 0;
        }
    }
}
