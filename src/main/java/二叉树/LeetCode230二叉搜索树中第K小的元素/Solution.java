package 二叉树.LeetCode230二叉搜索树中第K小的元素;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        int ans = new Solution().kthSmallest(root, 3);
        System.out.println(ans);
    }

    public int kthSmallest(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.kthSmallest(k);
    }
}

class MyBst {
    TreeNode root;
    Map<TreeNode, Integer> nodeNum;

    public MyBst(TreeNode root) {
        this.root = root;
        this.nodeNum = new HashMap<>();
        countNodeNum(root);
    }

    public int kthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            int left = nodeNum.getOrDefault(node.left, 0);
            if (left < k - 1) {
                node = node.right;
                k -= left + 1;
            }
            else if (left == k - 1) {
                break;
            }
            else {
                node = node.left;
            }
        }
        return node.val;
    }

    private int countNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        nodeNum.put(node, countNodeNum(node.left) + countNodeNum(node.right) + 1);
        return nodeNum.get(node);
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
