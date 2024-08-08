package 动态规划.LeetCode279完全平方数;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = new Solution().numSquares(n);
        System.out.println(ans);
    }

    public int numSquares(int n) {
        if (check(n)) {
            return 1;
        }
        for (int i = 1; i * i <= n; i++) {
            if (check(n - i * i)) {
                return 2;
            }
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        return 3;
    }

    private boolean check(int n) {
        int k = (int) Math.sqrt(n);
        return n == k * k;
    }
}
