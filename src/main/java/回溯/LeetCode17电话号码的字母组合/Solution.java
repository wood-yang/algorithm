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

    List<String> ans;
    char[][] letter;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        letter = new char[10][4];
        letter[2] = new char[]{'a', 'b', 'c'};
        letter[3] = new char[]{'d', 'e', 'f'};
        letter[4] = new char[]{'g', 'h', 'i'};
        letter[5] = new char[]{'j', 'k', 'l'};
        letter[6] = new char[]{'m', 'n', 'o'};
        letter[7] = new char[]{'p', 'q', 'r', 's'};
        letter[8] = new char[]{'t', 'u', 'v'};
        letter[9] = new char[]{'w', 'x', 'y', 'z'};
        char[] chars = new char[digits.length()];
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        backtrack(chars, digits, 0);
        return ans;
    }

    private void backtrack(char[] chars, String digits, int level) {
        if (level == digits.length()) {
            ans.add(new String(chars));
            return;
        }
        int num = digits.charAt(level) - '0';
        for (int j = 0; j < letter[num].length; j++) {
            chars[level] = letter[num][j];
            backtrack(chars, digits, level + 1);
        }
    }
}
