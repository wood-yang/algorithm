package 二叉树.LeetCode101对称二叉树;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        boolean b = new Solution().isSymmetric(root);
        System.out.println(b);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
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
