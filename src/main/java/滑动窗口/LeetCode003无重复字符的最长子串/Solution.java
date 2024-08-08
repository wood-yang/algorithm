package 滑动窗口.LeetCode003无重复字符的最长子串;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ans = new Solution().lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int l = 0;
        int r = 0;
        int ans = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (true) {
            int len = r - l;
            ans = Math.max(ans, len);
            if (r == s.length()) {
                break;
            }
            if (!hashSet.contains(s.charAt(r))) {
                hashSet.add(s.charAt(r));
                r++;
            }
            else {
                hashSet.remove(s.charAt(l));
                l++;
            }
        }
        return ans;
    }
}
