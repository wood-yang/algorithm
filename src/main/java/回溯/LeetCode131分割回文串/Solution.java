package 回溯.LeetCode131分割回文串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<List<String>> partition = new Solution().partition(s);
        System.out.println(partition);
    }

    List<List<String>> ans;
    boolean[][] f;
    public List<List<String>> partition(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(j) == s.charAt(j + i) && f[j + 1][j + i - 1]) {
                    f[j][j + i] = true;
                }
            }
        }
        backtrack(s, 0, s.length() - 1, new ArrayList<>());

        return ans;
    }

    private void backtrack(String s, int l, int r, List<String> list) {
        if (l == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = l; i <= r; i++) {
            if (f[l][i]) {
                list.add(s.substring(l, i + 1));
                backtrack(s, i + 1, r, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
