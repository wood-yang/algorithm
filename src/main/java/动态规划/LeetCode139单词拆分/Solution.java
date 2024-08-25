package 动态规划.LeetCode139单词拆分;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        List<String> wordDict = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wordDict.add(scanner.next());
        }
        boolean b = new Solution().wordBreak(s, wordDict);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 的含义为，长度为 i 的 s 是否能拼凑出来
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && check(s, i - word.length(), word) && dp[i - word.length()]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    private boolean check(String s, int index, String word) {
        if (s.length() < word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(index + i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
