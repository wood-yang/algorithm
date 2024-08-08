package 栈.LeetCode739每日温度;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] temperatures = new int[n];
        for (int i = 0; i < n; i++) {
            temperatures[i] = scanner.nextInt();
        }
        int[] ints = new Solution().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> tem = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (tem.isEmpty()) {
                tem.add(i);
                ans[i] = 0;
            }
            else {
                while (!tem.isEmpty() && temperatures[i] > temperatures[tem.getLast()]) {
                    Integer last = tem.removeLast();
                    ans[last] = i - last;
                }
                tem.add(i);
            }
        }
        return ans;
    }
}
