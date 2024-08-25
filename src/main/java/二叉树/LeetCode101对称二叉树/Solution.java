package 二叉树.LeetCode101对称二叉树;

import 二叉树.TreeNode;

import java.util.LinkedList;

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

    private boolean check(TreeNode u, TreeNode v) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(u);
        deque.offer(v);
        while (!deque.isEmpty()) {
            u = deque.poll();
            v = deque.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }
            deque.offer(u.left);
            deque.offer(v.right);

            deque.offer(u.right);
            deque.offer(v.left);
        }
        return true;
    }
}
