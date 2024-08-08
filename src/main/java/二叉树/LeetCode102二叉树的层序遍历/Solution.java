package 二叉树.LeetCode102二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> lists = new Solution().levelOrder(root);
        System.out.println(lists);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            ans.add(level);
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
