package 回溯.LeetCode17电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.next();
        List<String> list = new Solution().letterCombinations(digits);
        System.out.println(list);
    }

    List<String> ans = new ArrayList<>();
    char[][] letter;
    public List<String> letterCombinations(String digits) {
        letter = new char[10][4];
        letter[2] = new char[]{'a', 'b', 'c'};
        letter[3] = new char[]{'d', 'e', 'f'};
        letter[4] = new char[]{'g', 'h', 'i'};
        letter[5] = new char[]{'j', 'k', 'l'};
        letter[6] = new char[]{'m', 'n', 'o'};
        letter[7] = new char[]{'p', 'q', 'r', 's'};
        letter[8] = new char[]{'t', 'u', 'v'};
        letter[9] = new char[]{'w', 'x', 'y', 'z'};
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        backtrack(new char[digits.length()], digits, 0);
        return ans;
    }

    private void backtrack(char[] ch, String digits, int level) {
        if (ch.length == level) {
            ans.add(new String(ch));
            return;
        }
        int num = digits.charAt(level) - '0';
        for (int i = 0; i < letter[num].length; i++) {
            ch[level] = letter[num][i];
            backtrack(ch, digits, level + 1);
        }
    }
}
