package 技巧.LeetCode75颜色分类;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        new Solution().sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                nums[i] = nums[p2];
                nums[p2--] = 2;
            }
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
            }
        }
    }
}
