package 回溯.LeetCode39组合总和;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        List<List<Integer>> lists = new Solution().combinationSum(nums, target);
        System.out.println(lists);
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<Integer> temp, int level) {
        if (level == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        backtrack(candidates, target, temp, level + 1);
        if (target >= candidates[level]) {
            temp.add(candidates[level]);
            backtrack(candidates, target - candidates[level], temp, level);
            temp.remove(temp.size() - 1);
        }
    }
}
