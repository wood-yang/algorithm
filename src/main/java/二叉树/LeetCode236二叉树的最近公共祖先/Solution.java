package 二叉树.LeetCode236二叉树的最近公共祖先;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        root.left = p;
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode q = new TreeNode(1);
        root.right = q;
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode treeNode = new Solution().lowestCommonAncestor(root, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        TreeNode ans = root;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (check(node, p) && check(node, q)) {
                    ans = node;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return ans;
    }

    private boolean check(TreeNode root, TreeNode target) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (target == node) {
                    return true;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return false;
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