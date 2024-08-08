package 二分查找.LeetCode35搜索插入位置;

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
        int ans = new Solution().searchInsert(nums, target);
        System.out.println(ans);
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                return mid;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
