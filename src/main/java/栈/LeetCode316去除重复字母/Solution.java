package 栈.LeetCode316去除重复字母;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String ans = new Solution().removeDuplicateLetters(s);
        System.out.println(ans);
    }

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                while (!stack.isEmpty() && count[stack.getLast() - 'a'] > 0 && c <= stack.getLast()) {
                    visited[stack.getLast() - 'a'] = false;
                    stack.removeLast();
                }
                stack.addLast(c);
                visited[c - 'a'] = true;
            }
            count[c - 'a']--;
        }

        StringBuilder ans = new StringBuilder();
        for (Character c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}
