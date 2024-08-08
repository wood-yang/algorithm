package 堆.LeetCode347前K个高频元素;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] ans = new Solution().topKFrequent(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            queue.offer(new int[]{num, count});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}

