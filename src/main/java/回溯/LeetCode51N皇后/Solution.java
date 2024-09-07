package 回溯.LeetCode51N皇后;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<String>> lists = new Solution().solveNQueens(n);
        System.out.println(lists);
    }

    List<List<String>> ans;
    char[] empty;
    boolean[] visited;
    boolean[] visitedL;
    boolean[] visitedR;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        visited = new boolean[n];
        visitedL = new boolean[2 * n - 1];
        visitedR = new boolean[2 * n - 1];
        empty = new char[n];
        for (int i = 0; i < n; i++) {
            empty[i] = '.';
        }
        backtrack(n, new ArrayList<>(), new char[n], 0);

        return ans;
    }

    private void backtrack(int n, List<String> list, char[] chars, int level) {
        if (level == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 按行遍历，确保行是不会相撞的，于是判定列、两个对角线是否冲突即可
        for (int i = 0; i < n; i++) {
            if (visited[i] || visitedL[n + level - i - 1] || visitedR[level + i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                chars[j] = '.';
            }
            chars[i] = 'Q';
            visited[i] = true;
            visitedL[level + n - i - 1] = true;
            visitedR[level + i] = true;
            list.add(new String(chars));
            backtrack(n, list, chars, level + 1);
            chars[i] = '.';
            visited[i] = false;
            visitedL[level + n - i - 1] = false;
            visitedR[level + i] = false;
            list.remove(list.size() - 1);
        }
    }
}
