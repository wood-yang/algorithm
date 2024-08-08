package 贪心.LeetCode55跳跃游戏;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean b = new Solution().canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int far = 0;
        for (int i = 0; i < n; i++) {
            if (i > far) {
                return false;
            }
            far = Math.max(far, i + nums[i]);
        }
        return far >= n - 1;
    }
}
