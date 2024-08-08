package 技巧.LeetCode137只出现一次的数字II;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = new Solution().singleNumber(nums);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            //计算每个数字第i位上的总和, 满足3n+k, k即为答案的第i位数字(0或者1)
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
