package 二叉树.LeetCode437路径总和III;

import 二叉树.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        int targetSum = 8;
        int i = new Solution().pathSum(root, targetSum);
        System.out.println(i);
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        curr += root.val;
        int res = prefix.getOrDefault(curr - targetSum, 0);
        // 保存目前的前缀和，用以后面子树里面的节点到根节点的前缀和
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, prefix, curr, targetSum);
        res += dfs(root.right, prefix, curr, targetSum);
        // 当前节点的左右子树已经全部遍历完，也就是说以这个节点就不会再使用了，所以把它除去，因为题设要求需要统计向下的路径个数
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return res;
    }
}
