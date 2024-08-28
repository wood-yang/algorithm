package 普通数组.LeetCode238除自身以外数组的乘积;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ints = new Solution().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;

            int[] ans = new int[n];
            ans[0] = 1;
            // ans[i] 此处暂时表示 nums[i] 的左边所有数的乘积
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
            // mul 表示 nums[i] 的右边所有数的乘积
            int mul = 1;
            for (int i = n - 2; i >= 0; i--) {
                mul *= nums[i + 1];
                ans[i] = ans[i] * mul;
            }

            return ans;
        }
}
