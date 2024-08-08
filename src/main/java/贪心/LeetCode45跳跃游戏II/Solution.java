package 贪心.LeetCode45跳跃游戏II;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int jump = new Solution().jump(nums);
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int location = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            location = Math.max(location, i + nums[i]);
            if (i == end) {
                step++;
                end = location;
            }
        }
        return step;
    }
}
