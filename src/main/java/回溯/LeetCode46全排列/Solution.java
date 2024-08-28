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

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), visited);
        return ans;
    }

    private void helper(int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                helper(nums, temp, visited);
                visited[i] = false;
                temp.remove(Integer.valueOf(temp.size() - 1));
            }
        }
    }
}
