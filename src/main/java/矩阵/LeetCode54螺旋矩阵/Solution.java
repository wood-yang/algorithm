package 矩阵.LeetCode54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        List<Integer> list = new Solution().spiralOrder(matrix);
        System.out.println(list);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int r = 0;
        int c = 0;
        int index = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[r][c]);
            visited[r][c] = true;
            int newR = r + directions[index][0];
            int newC = c + directions[index][1];
            if (newR < 0 || newR >= m || newC < 0 || newC >= n || visited[newR][newC]) {
                index = (index + 1) % 4;
            }
            r += directions[index][0];
            c += directions[index][1];
        }
        return list;
    }
}
