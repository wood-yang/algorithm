package 二叉树.LeetCode114二叉树展开为链表;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        new Solution().flatten(root);
    }

    LinkedList<TreeNode> deque = new LinkedList<>();
    public void flatten(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        helper(root);
        root = dummy;
        int n = deque.size();
        for (int i = 0; i < n; i++) {
            root.right = deque.poll();
            root.left = null;
            root = root.right;
        }
        root = dummy.right;
    }

    public void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        deque.offer(node);
        helper(node.left);
        helper(node.right);
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
