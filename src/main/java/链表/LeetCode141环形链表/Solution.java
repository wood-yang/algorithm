package 链表.LeetCode141环形链表;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = null;
        ListNode huan = null;
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            ListNode node = null;
            if (i == 0) {
                node = new ListNode(scanner.nextInt());
                huan = node;
            }
            else {
                node = new ListNode(scanner.nextInt(), head);
            }
            head = node;
        }
        head.next.next.next = head;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            head = new ListNode(scanner.nextInt(), head);
        }

        boolean b = new Solution().hasCycle(head);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
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
                return false;
            }
        }
        return true;
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
