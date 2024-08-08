package 子串.LeetCode560和为K的子数组;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int ans = new Solution().subarraySum(nums, k);
        System.out.println(ans);
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        hashMap.put(0 ,1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum - k)) {
                ans += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

}
