package 技巧.LeetCode169多数元素;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().majorityElement(nums);
        System.out.println(ans);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
