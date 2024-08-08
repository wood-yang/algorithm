package 图论.LeetCode210课程表II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCourses = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] prerequisites = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                prerequisites[i][j] = scanner.nextInt();
            }
        }
        int[] order = new Solution().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    int[] ans;
    int index;
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        ans = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (valid) {
            return ans;
        }
        return new int[]{};
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
            }
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        ans[index--] = u;
    }
}
