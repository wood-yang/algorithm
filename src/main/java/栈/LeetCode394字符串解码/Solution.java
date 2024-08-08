package 栈.LeetCode394字符串解码;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String ans = new Solution().decodeString(s);
        System.out.println(ans);
    }

    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        LinkedList<Integer> stack_num = new LinkedList<>();
        LinkedList<String> stack_letter = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                ans.append(cur);
                stack_letter.add(cur.toString());
                stack_num.add(num);
                cur = new StringBuilder();
                num = 0;
            }
            else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                Integer count = stack_num.removeLast();
                for (int j = 0; j < count; j++) {
                    temp.append(cur);
                }
                cur = new StringBuilder(stack_letter.removeLast() + temp);
            }
            else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            else {
                cur.append(c);
            }
        }

        return ans.toString();
    }
}
