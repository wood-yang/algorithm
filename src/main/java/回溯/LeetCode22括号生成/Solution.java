package 回溯.LeetCode22括号生成;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new Solution().generateParenthesis(n);
        System.out.println(list);
    }

    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(n, 0, 0, 0, new char[2 * n]);

        return ans;
    }

    private void backtrack(int n, int lCount, int rCount, int level, char[] chars) {
        if (lCount < rCount || lCount > n) {
            return;
        }
        if (level == chars.length) {
            if (lCount == rCount) {
                ans.add(new String(chars));
            }
            return;
        }
        chars[level] = '(';
        backtrack(n, lCount + 1, rCount, level + 1, chars);
        chars[level] = ')';
        backtrack(n, lCount, rCount + 1, level + 1, chars);
    }
}
