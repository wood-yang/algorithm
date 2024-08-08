package 动态规划.LeetCode70爬楼梯;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = new Solution().climbStairs(n);
        System.out.println(ans);
    }

    public int climbStairs(int n) {
        int[][] a = new int[][]{{1, 1}, {1, 0}};
        int[][] ans = pow(a, n);
        return ans[1][0] + ans[1][1];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] ans = new int[][]{{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = multi(ans, a);
            }
            a = multi(a, a);
            n >>= 1;
        }
        return ans;
    }

    private int[][] multi(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
