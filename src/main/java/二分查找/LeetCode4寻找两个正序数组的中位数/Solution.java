package 二分查找.LeetCode4寻找两个正序数组的中位数;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        double median;
        if ((m + n) % 2 == 1) {
            median = getKthElement(nums1, nums2, mid + 1);
        }
        else {
            median = (getKthElement(nums1, nums2, mid) + getKthElement(nums1, nums2, mid + 1)) / 2.0;
        }

        return median;
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int ans = 0;

        while (true) {
            //边界情况
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            //正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, m) - 1;
            int newIndex2 = Math.min(index2 + half, n) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }
            else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
