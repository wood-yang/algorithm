package 双指针.LeetCode42接雨水;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] height = new int[n];
//        for (int i = 0; i < n; i++) {
//            height[i] = scanner.nextInt();
//        }
        int[] nums = new int[]{0,7,1,4,6};
        int ans = new Solution().trap(nums);
        System.out.println(ans);
    }

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int[] max_left = new int[n];
        max_left[0] = height[0];
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }

        int[] max_right = new int[n];
        max_right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && i < n - 1) {
                int lmax = max_left[i - 1];
                int rmax = max_right[i + 1];
                if (height[i] < Math.min(lmax, rmax)) {
                    ans += Math.min(lmax, rmax) - height[i];
                }
            }
        }

        return ans;
    }
}
