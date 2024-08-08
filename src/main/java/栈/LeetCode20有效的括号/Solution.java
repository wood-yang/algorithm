package 栈.LeetCode20有效的括号;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        boolean valid = new Solution().isValid(s);
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.removeLast() != '(') {
                    return false;
                }
            }
            else if (c == '}') {
                if (stack.isEmpty() || stack.removeLast() != '{') {
                    return false;
                }
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.removeLast() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
