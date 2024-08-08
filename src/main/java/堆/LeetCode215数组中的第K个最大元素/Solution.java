package 堆.LeetCode215数组中的第K个最大元素;

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
        int kthLargest = new Solution().findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return quickSort(list, k);
    }

    private int quickSort(List<Integer> nums, int k) {
        //随机选择基准数
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));
        //将小于 等于 大于 pivot的元素划分至 small equal big 中
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        for (Integer num : nums) {
            if (num < pivot) {
                small.add(num);
            }
            else if (num > pivot) {
                big.add(num);
            }
            else {
                equal.add(num);
            }
        }
        if (k <= big.size()) {
            return quickSort(big, k);
        }
        else if (big.size() + equal.size() > k) {
            return quickSort(small, k - (big.size() + equal.size()));
        }
        else {
            return pivot;
        }
    }
}
