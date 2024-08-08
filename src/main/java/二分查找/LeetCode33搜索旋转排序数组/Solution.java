package 二分查找.LeetCode33搜索旋转排序数组;

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
        int ans = new Solution().search(nums, target);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i + 1;
            }
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[(mid + k) % n] < target) {
                l = mid + 1;
            }
            else if (nums[(mid + k) % n] > target) {
                r = mid - 1;
            }
            else {
                return (mid + k) % n;
            }
        }
        return -1;
    }
}
