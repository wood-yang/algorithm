package 回溯.LeetCode46全排列;

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
        List<List<Integer>> permute = new Solution().permute(nums);
        System.out.println(permute);
    }

    List<List<Integer>> ans;
    int[] visited;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        helper(list, nums, 0);
        return ans;
    }

    private void helper(List<Integer> list, int[] nums, int level) {
        if (level == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                list.add(nums[i]);
                visited[i] = 1;
                helper(list, nums, level + 1);
                list.remove(Integer.valueOf(nums[i]));
                visited[i] = 0;
            }
        }
    }
}
