package 二分查找.LeetCode154寻找旋转排序数组中的最小值2;

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
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] < nums[r]) {
                r = mid;
            }
            else if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                if (nums[l] < nums[mid]) {
                    return nums[l];
                }
                else if (nums[l] > nums[mid]) {
                    r = mid;
                }
                else {
                    int min = nums[l];
                    for (int i = l + 1; i <= r; i++) {
                        min = Math.min(min, nums[i]);
                    }
                    return min;
                }
            }
        }
        return nums[l];
    }
}
