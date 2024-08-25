package 二叉树.LeetCode114二叉树展开为链表;

import 二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        new Solution().flatten(root);
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为null，说明左半部分不需要再修改（包括根节点），直接进行下面的修改接口
            if (root.left == null) {
                root = root.right;
            } else {
                // 当左子树不为null时，寻找先序遍历中 left节点的最右边（只能位于root.left的右边）
                // 为什么？？？？？？？？？？？？？？？？？？？
                // 首先需要想象一个操作顺序：结果是需要一个右斜的链表
                // 如果顺着左节点走的话，会保留往左倾的连线，所以意思应该是只保留右倾的连线
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将根节点的right拼接在pre节点的右边
                pre.right = root.right;
                // 将根节点的left拼接到right
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

}
