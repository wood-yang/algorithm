package 普通数组.LeetCode189轮转数组;

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
        int k = scanner.nextInt();
        new Solution().rotate(nums, k);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];

        // temp 数组存储的 后k位索引位置的数，所以我们可以先用这个位置的数作为中转，最后用temp给这些位置的数赋值
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - 1 - i];
        }
        int a = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i >= k) {
                nums[i] = nums[i - k];
            }
            else {
                nums[i] = temp[a++];
            }
        }
        System.out.println(Arrays.toString(nums));
     }
}
