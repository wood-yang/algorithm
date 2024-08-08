package 哈希.LeetCode001两数之和;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int[] ans = new Solution().twoSum(num, target);

        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = target - nums[i];
            if (hashtable.containsKey(key)) {
                return new int[]{i, hashtable.get(key)};
            }
            else {
                hashtable.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
