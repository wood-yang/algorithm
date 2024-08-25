package 二叉树.LeetCode124二叉树中的最大路径和;

import 二叉树.TreeNode;

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
        // lMax rMax 表示左/右子树的向下的路径的最大的和
        int lMax = helper(node.left);
        int rMax = helper(node.right);
        // 如果路径和小于0，那就不连接到当前的节点，置为0即可
        lMax = Math.max(lMax, 0);
        rMax = Math.max(rMax, 0);
        // 判断目前连接路径的和是否大于之前的，若是则替代即可
        int sum = node.val + lMax + rMax;
        ans = Math.max(ans, sum);
        // 返回一条向下的路径，而不是某个节点有两个子节点的那种路径
        // 意思就是 可供连接的路径的和 的最大值
        return node.val + Math.max(lMax, rMax);
    }
}