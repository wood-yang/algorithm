package 矩阵.LeetCode289生命游戏;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        new Solution().gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isLive = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = count(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        isLive[i][j] = true;
                    }
                }
                else {
                    if (count == 3) {
                        isLive[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isLive[i][j]) {
                    board[i][j] = 1;
                }
                else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int count(int[][] board, int r, int c) {
        int count = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
        for (int i = 0; i < 8; i++) {
            int newR = r + directions[i][0];
            int newL = c + directions[i][1];
            if (newR >= 0 && newR < board.length && newL >= 0 && newL < board[0].length) {
                count += board[newR][newL];
            }
        }
        return count;
    }
}
