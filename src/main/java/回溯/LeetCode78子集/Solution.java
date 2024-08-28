package 回溯.LeetCode78子集;

import java.util.ArrayList;
import java.util.HashSet;
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
        List<List<Integer>> subsets = new Solution().subsets(nums);
        System.out.println(subsets);
    }

    /**
     * 迭代法(用位)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    temp.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(temp));
            temp.clear();
        }
        return ans;
    }

    /**
     * 回溯法
     */
//    List<List<Integer>> ans;
//    public List<List<Integer>> subsets(int[] nums) {
//        ans = new ArrayList<>();
//        backtrack(new ArrayList<>(), nums, 0);
//        return ans;
//    }
//
//    private void backtrack(List<Integer> list, int[] nums, int index) {
//        if (index == nums.length) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        backtrack(list, nums, index + 1);
//        list.add(nums[index]);
//        backtrack(list, nums, index + 1);
//        list.remove(list.size() - 1);
//    }
}
