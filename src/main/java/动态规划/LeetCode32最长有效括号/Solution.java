package 动态规划.LeetCode32最长有效括号;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ans = new Solution().longestValidParentheses(s);
        System.out.println(ans);
    }

//    /**
//     * 方法一：动态规划
//     * @param s
//     * @return
//     */
//    public int longestValidParentheses(String s) {
//        int n = s.length();
//        int[] dp = new int[n];
//        int ans = 0;
//        for (int i = 1; i < n; i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
//                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
//                }
//                ans = Math.max(ans, dp[i]);
//            }
//        }
//        return ans;
//    }


    /**
     * 方法二：贪心
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if (left < right) {
                left = 0;
                right = 0;
            }
            else if (left == right) {
                ans = Math.max(ans, left * 2);
            }
        }
        left = 0;
        right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else {
                right++;
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
            else if (left == right) {
                ans = Math.max(ans, right * 2);
            }
        }
        return ans;
    }
}
