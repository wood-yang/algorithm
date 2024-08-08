package 子串.LeetCode76最小覆盖子串;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        String ans = new Solution().minWindow(s, t);

        System.out.println(ans);
    }

    public String minWindow(String s, String t) {
        int[] sCount = new int[100];
        int[] tCount = new int[100];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'A']++;
        }
        int l = 0;
        int r = 0;
        int[] ans = new int[]{0, 0};
        int len = 100007;
        while (true) {
            if (r != s.length()) {
                sCount[s.charAt(r++) - 'A']++;
            }
            if (check(sCount, tCount)) {
                while (check(sCount, tCount)) {
                    sCount[s.charAt(l) - 'A']--;
                    l++;
                }
                l--;
                if (r - l < len) {
                    len = r - l;
                    ans[0] = l;
                    ans[1] = r;
                }
                l++;
            }
            else if (!check(sCount, tCount) && r == s.length()) {
                break;
            }
        }
        return s.substring(ans[0], ans[1]);
    }
    private boolean check(int[] s, int[] t) {
        for (int i = 0; i < 100; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }
        return true;
    }
}
