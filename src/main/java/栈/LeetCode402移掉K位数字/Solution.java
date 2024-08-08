package 栈.LeetCode402移掉K位数字;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int k = scanner.nextInt();
        String s = new Solution().removeKdigits(num, k);
        System.out.println(s);
    }

    public String removeKdigits(String num, int k) {
        int n = num.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && c < stack.getLast() && k > 0) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        StringBuilder ans = new StringBuilder();
        boolean flag = true;
        for (Character c : stack) {
            if (flag) {
                if (c != '0') {
                    ans.append(c);
                    flag = false;
                }
            }
            else {
                ans.append(c);
            }
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
