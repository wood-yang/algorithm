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

    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        int left = 0;
        int right = 0;
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
                ans = Math.max(ans, 2 * left);
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
                ans = Math.max(ans, 2 * left);
            }
        }
        return ans;
    }
}
