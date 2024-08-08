package 普通数组.LeetCode442数组中重复的数据;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        List<Integer> duplicates = new Solution().findDuplicates(nums);
        System.out.println(duplicates);
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
            else {
                ans.add(index);
            }
        }
        return ans;
    }
}
