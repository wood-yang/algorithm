package 链表.LeetCode142环形链表II;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = null;
        ListNode huan = null;
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            ListNode node = null;
            node = new ListNode(scanner.nextInt());
            if (i == 0) {
                huan = node;
            }
            node.next = head;
            head = node;
        }
        huan.next = head;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            node.next = head;
            head = node;
        }

        ListNode listNode = new Solution().detectCycle(head);
        System.out.println(listNode);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode quick = head.next.next;
        while (slow != quick) {
            if (slow != null) {
                slow = slow.next;
            }
            if (quick != null && quick.next != null) {
                quick = quick.next.next;
            }
            else {
                return null;
            }
        }
        quick = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}