package 栈.LeetCode321拼接最大数;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] ans = new Solution().maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxSubsequence = new int[k];
        //从nums1中最少取的个数
        int start = Math.max(0, k - n);
        //从nums1中最多取的个数
        int end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            //分别从nums1和nums2中取i和k-i个数
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            //将这k个数合并成最大的数
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            //然后和最后的结果比较，取较大值
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > stack.getLast() && n - i - 1 >= k) {
                stack.removeLast();
                k++;
            }
            if (k > 0) {
                stack.addLast(nums[i]);
                k--;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.removeFirst();
        }
        return ans;
    }

    private int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length;
        int y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLen = x + y;
        int[] merged = new int[mergeLen];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < mergeLen; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    private int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length;
        int y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        //有一个数组遍历完了, 其中还没遍历完的数组更大
        return (x - index1) - (y - index2);
    }
}

