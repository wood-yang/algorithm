package 二叉树.LeetCode108将有序数组转换为二叉搜索树;

import 二叉树.TreeNode;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        TreeNode treeNode = new Solution().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return getRoot(nums, 0, nums.length - 1);
    }

    private TreeNode getRoot(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRoot(nums, l, mid - 1);
        root.right = getRoot(nums, mid + 1, r);
        return root;
    }
}
