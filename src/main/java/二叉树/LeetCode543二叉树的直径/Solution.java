package 二叉树.LeetCode543二叉树的直径;

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
        longestSide(root);
        return ans;
    }

    private int longestSide(TreeNode root) {
        int l, r;
        if (root == null) {
            return -1;
        }
        else {
            l = longestSide(root.left) + 1;
            r = longestSide(root.right) + 1;
            if (l + r > ans) {
                ans = l + r;
            }
        }
        return Math.max(l, r);
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
