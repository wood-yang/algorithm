package 普通数组.LeetCode624数组列表中的最大距离;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int n = scanner.nextInt();
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                array.add(scanner.nextInt());
            }
            arrays.add(array);
        }
        int ans = new Solution().maxDistance(arrays);
        System.out.println(ans);
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        for (int i = 1; i < arrays.size(); i++) {
            Integer first = arrays.get(i).get(0);
            Integer last = arrays.get(i).get(arrays.get(i).size() - 1);
            ans = Math.max(ans, Math.max(max - first, last - min));
            max = Math.max(max, last);
            min = Math.min(min, first);
        }
        return ans;
    }
}
