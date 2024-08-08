package 二叉树.LeetCode105从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = scanner.nextInt();
        }
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
        }
        TreeNode treeNode = new Solution().buildTree(pre, in);
    }

    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode helper = helper(preorder, inorder, 0, n - 1, 0, n - 1);
        return helper;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        //前序遍历中, 第一个节点就是根节点
        int preorder_root = l1;
        //在中序遍历中找到根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        //先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树中的节点数目
        int size_left = inorder_root - l2;
        root.left = helper(preorder, inorder, l1 + 1, l1 + size_left, l2, inorder_root - 1);
        //构造右子树
        root.right = helper(preorder, inorder, l1 + size_left + 1, r1, inorder_root + 1, r2);

        return root;
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
