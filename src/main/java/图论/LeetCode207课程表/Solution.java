package 图论.LeetCode207课程表;

import java.util.*;

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
        boolean b = new Solution().canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    int[] ans;
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
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
    }
}
