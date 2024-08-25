package 二分查找.LeetCode34在排序数组中查找元素的第一个和最后一个位置;

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
        int target = scanner.nextInt();
        int[] ans = new Solution().searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[]{-1, -1};
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            int x = nums[mid];
            if (x > target) {
                r = mid - 1;
            }
            else if (x < target) {
                l = mid + 1;
            }
            else {
                ans[0] = mid;
                r = mid - 1;
            }
        }

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            int x = nums[mid];
            if (x > target) {
                r = mid - 1;
            }
            else if (x < target) {
                l = mid + 1;
            }
            else {
                ans[1] = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}
