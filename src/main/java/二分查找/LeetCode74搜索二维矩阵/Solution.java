package 二分查找.LeetCode74搜索二维矩阵;

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
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            else if (x < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return false;
    }
}
