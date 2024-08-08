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

    List<List<Integer>> ans;
    List<Integer> combine;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        combine = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, combine, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        //直接跳过
        backtrack(candidates, target, combine, index + 1);
        //选择当前数
        if (target >= candidates[index]) {
            target -= candidates[index];
            combine.add(candidates[index]);
            backtrack(candidates, target, combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
