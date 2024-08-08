package 哈希.LeetCode128最长连续序列;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().longestConsecutive(nums);
        System.out.println(ans);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        int len = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(num)) {
                len++;
                num++;
            }
            ans = Math.max(ans, len);
            len = 0;
        }

        return ans;
    }
}
