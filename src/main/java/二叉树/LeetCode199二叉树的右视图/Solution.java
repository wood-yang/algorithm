package 二叉树.LeetCode199二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        List<Integer> list = new Solution().rightSideView(root);
        System.out.println(list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = list.poll();
                if (i == 0) {
                    ans.add(node.val);
                }
                if (node.right != null) {
                    list.offer(node.right);
                }
                if (node.left != null) {
                    list.offer(node.left);
                }
            }
        }
        return ans;
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