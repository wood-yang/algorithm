package 贪心.LeetCode763划分字母区间;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        List<Integer> list = new Solution().partitionLabels(s);
        System.out.println(list);
    }

    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] location = new int[26];
        for (int i = 0; i < n; i++) {
            location[array[i] - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, location[array[i] - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
