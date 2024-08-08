package 二叉树.LeetCode108将有序数组转换为二叉搜索树;

import java.util.LinkedList;
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
        return getRoot(0, nums.length - 1, nums);
    }

    private TreeNode getRoot(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRoot(l, mid - 1, nums);
        root.right = getRoot(mid + 1, r, nums);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}