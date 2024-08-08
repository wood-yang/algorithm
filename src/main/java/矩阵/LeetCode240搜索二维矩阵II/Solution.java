package 矩阵.LeetCode240搜索二维矩阵II;

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
        int target = scanner.nextInt();
        boolean b = new Solution().searchMatrix(matrix, target);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = n - 1;
        while (true) {
            if (x > m - 1 || y < 0) {
                break;
            }
            if (matrix[x][y] > target) {
                y--;
            }
            else if (matrix[x][y] < target) {
                x++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
