package 矩阵.LeetCode73矩阵置零;

import java.util.Arrays;
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
        new Solution().setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        flag1 = 1;
                    }
                    if (j == 0) {
                        flag2 = 1;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flag1 == 1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (flag2 == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }
}
