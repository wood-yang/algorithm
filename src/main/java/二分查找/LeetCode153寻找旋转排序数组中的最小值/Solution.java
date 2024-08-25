package 二分查找.LeetCode153寻找旋转排序数组中的最小值;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int min = new Solution().findMin(nums);
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int min = 0;
        int l = 1;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[0] < nums[mid]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
                min = mid;
            }
        }
        return nums[min];
    }
}
