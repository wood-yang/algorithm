package 二叉树.LeetCode105从前序与中序遍历序列构造二叉树;

import 二叉树.TreeNode;

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
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
        int root_pre_index = preL;
        int root_in_index = indexMap.get(preorder[root_pre_index]);
        TreeNode root = new TreeNode(preorder[preL]);
        int leftNum = root_in_index - inL;
        int rightNum = inR - root_in_index;
        if (leftNum > 0) {
            root.left = helper(preorder, inorder, preL + 1, preL + leftNum, inL, root_in_index - 1);
        }
        if (rightNum > 0) {
            root.right = helper(preorder, inorder, preL + leftNum + 1, preR, root_in_index + 1, inR);
        }
        return root;
    }
}
