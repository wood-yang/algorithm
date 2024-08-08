package 链表.LeetCode206反转链表;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = null;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ListNode node = null;
            if (i == 0) {
                node = new ListNode(scanner.nextInt());
            } else {
                node = new ListNode(scanner.nextInt(), head);
            }
            head = node;
        }

        ListNode ans = new Solution().reverseList(head);
        System.out.println(ans);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            pre = new ListNode(cur.val, pre);
            cur = cur.next;
        }
        return pre;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
