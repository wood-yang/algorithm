package 普通数组.LeetCode26删除有序数组中的重复项;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().removeDuplicates(nums);
        System.out.println(ans);
    }

    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
