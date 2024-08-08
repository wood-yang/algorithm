package 滑动窗口.LeetCode438找到字符串中所有字母异位词;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
        List<Integer> anagrams = new Solution().findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int sLen = s.length();
        int pLen = p.length();
        int sCount[] = new int[26];
        int pCount[] = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (Arrays.equals(sCount, pCount)) {
            list.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
