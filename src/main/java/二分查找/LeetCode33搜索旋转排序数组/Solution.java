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
        // k为偏移的大小，也就是最小值的索引
        int l = 1;
        int r = n - 1;
        // 这里不是二分找 target，而是找最小值的索引位置
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            int x = nums[mid];
            if (x > nums[0]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
                k = mid;
            }
        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            int x = nums[(mid + k) % n];
            if (x > target) {
                r = mid - 1;
            }
            else if (x < target) {
                l = mid + 1;
            }
            else {
                return (mid + k) % n;
            }
        }
        return -1;
    }
}
