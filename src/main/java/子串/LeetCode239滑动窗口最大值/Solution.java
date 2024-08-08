package 子串.LeetCode239滑动窗口最大值;

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
        int[] ans = new Solution().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = nums[deque.getFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (deque.getFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.getFirst()];
        }

        return ans;
    }
}
