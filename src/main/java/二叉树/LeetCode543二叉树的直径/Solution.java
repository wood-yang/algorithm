package 二叉树.LeetCode543二叉树的直径;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int i = new Solution().diameterOfBinaryTree(root);
        System.out.println(i);
    }

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = maxDepth(root.left);
        int rMax = maxDepth(root.right);
        ans = Math.max(ans, lMax + rMax);
        return Math.max(lMax, rMax) + 1;
    }
}


