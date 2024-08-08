package 双指针.LeetCode11盛最多水的容器;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        int ans = new Solution().maxArea(height);
        System.out.println(ans);
    }

    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                 l++;
            }
            else if (height[l] > height[r]) {
                r--;
            }
            else {

            }
        }

        return ans;
    }
}
