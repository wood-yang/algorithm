package 二叉树.LeetCode104二叉树的最大深度;

import 二叉树.TreeNode;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        int ans = new Solution().maxDepth(treeNode);
        System.out.println(ans);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int ans = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 1; i <= size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            ans++;
        }
        return ans;
    }


}
