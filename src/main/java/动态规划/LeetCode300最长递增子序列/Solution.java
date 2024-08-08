package 动态规划.LeetCode300最长递增子序列;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().lengthOfLIS(nums);
        System.out.println(ans);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        d[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len - 1]) {
                d[len++] = nums[i];
            }
            else {
                d[find(d, len, nums[i])] = nums[i];
            }
        }
        return len;
    }

    private int find(int[] d, int len, int target) {
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (d[mid] > target) {
                r = mid - 1;
            }
            else if (d[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return r + 1;
    }
}
