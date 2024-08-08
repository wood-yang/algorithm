package 技巧.LeetCode260只出现一次的数字III;

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
        int[] ans = new Solution().singleNumber(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        //防止溢出, lsb表示xorsum二进制表示中最低位的1 (不可能取不出来, 因为xorsum不可能为0)
        int lsb = (xorsum == Integer.MAX_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0;
        int type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            }
            else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
