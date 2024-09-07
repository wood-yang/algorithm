package 回溯.LeetCode79单词搜索;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = scanner.next().charAt(0);
                board[i][j] = c;
            }
        }
        String word = scanner.next();
        boolean exist = new Solution().exist(board, word);
        System.out.println(exist);
    }

    boolean[][] visited;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(board, word, 0, i, j);
                }
            }
        }

        return flag;
    }

    private void backtrack(char[][] board, String word, int level, int r, int c) {
        if (r < 0 || r == board.length || c < 0 || c == board[0].length || visited[r][c] || board[r][c] != word.charAt(level)) {
            return;
        }
        if (level == word.length() - 1) {
            flag = true;
            return;
        }
        // 把此时访问到的字母标记，并且调用函数后，又可以去标记调用的函数
        visited[r][c] = true;
        backtrack(board, word, level + 1, r + 1, c);
        backtrack(board, word, level + 1, r - 1, c);
        backtrack(board, word, level + 1, r, c + 1);
        backtrack(board, word, level + 1, r, c - 1);
        visited[r][c] = false;
    }
}
