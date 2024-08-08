package 二叉树.LeetCode124二叉树中的最大路径和;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int i = new Solution().maxPathSum(root);
        System.out.println(i);
    }

    int ans;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lMax = 0;
        int rMax = 0;
        int c;
        if ((c = helper(node.left)) > 0) {
            lMax = c;
        }
        if ((c = helper(node.right)) > 0) {
            rMax = c;
        }

        int sum = node.val + lMax + rMax;
        if (sum > ans) {
            ans = sum;
        }
        return node.val + Math.max(lMax, rMax);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}