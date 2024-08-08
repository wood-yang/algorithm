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

    List<List<Integer>> ans;
    HashSet<List<Integer>> set;
    int[] visited;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrack(list, nums, 0);
        ans.addAll(set);
        return ans;
    }

    private void backtrack(List<Integer> list, int[] nums, int index) {
        set.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 0) {
                list.add(nums[i]);
                visited[i] = 1;
                backtrack(list, nums, i + 1);
                list.remove(Integer.valueOf(nums[i]));
                visited[i] = 0;
            }
        }
    }
}
