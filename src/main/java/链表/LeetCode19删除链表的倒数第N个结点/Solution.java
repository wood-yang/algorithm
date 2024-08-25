package 链表.LeetCode19删除链表的倒数第N个结点;

import java.util.Scanner;
import java.util.Stack;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        int k = scanner.nextInt();
        ListNode listNode = new Solution().removeNthFromEnd(dummy.next, k);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 1; i <= n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return dummy.next;
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
}
