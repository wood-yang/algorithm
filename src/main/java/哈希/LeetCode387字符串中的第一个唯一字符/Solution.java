package 哈希.LeetCode387字符串中的第一个唯一字符;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int ans = new Solution().firstUniqChar(s);
        System.out.println(ans);
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, -1);
            }
            else {
                hashMap.put(c, i);
            }
        }

        int ans = s.length();
        for (Integer value : hashMap.values()) {
            if (value != -1 && value < ans) {
                ans = value;
            }
        }
        return ans == s.length() ? -1 : ans;
    }
}
