package 二叉树.LeetCode230二叉搜索树中第K小的元素;

import 二叉树.TreeNode;

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
        return myBst.findKthSmallest(k);
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

    public int findKthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            // 此时比根节点小的节点有多少个，如果取不到，说明此时 node.left 为null，设置为 0 即可
            int left = nodeNum.getOrDefault(node.left, 0);
            // 若左子树的所有节点个数 left 小于 k-1 个，说明第 k 小的元素 在右子树中
            // 且此时只需要找到第 k - left - 1 小的节点即可（还额外排除了根节点）
            if (left < k - 1) {
                node = node.right;
                k -= left + 1;
            }
            // 若刚好为 k - 1 个，则说明就是这个点
            else if (left == k - 1) {
                break;
            }
            // 若多于 k - 1 个，则说明在左子树里，且仍旧在找第 k 小的节点
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
        // 以这个节点为根节点的树的节点个数
        nodeNum.put(node, countNodeNum(node.left) + countNodeNum(node.right) + 1);
        return nodeNum.get(node);
    }
}
