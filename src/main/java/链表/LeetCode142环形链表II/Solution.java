package 链表.LeetCode142环形链表II;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode pre = new ListNode();
        ListNode cycleNode = new ListNode();
        int a = scanner.nextInt();
        int index = scanner.nextInt();
        ListNode p = pre;
        for (int i = 0; i < a; i++) {
            p.next = new ListNode(scanner.nextInt());
            if (i == index) {
                cycleNode = p;
            }
            p = p.next;
        }
        p.next = cycleNode;

        ListNode listNode = new Solution().detectCycle(pre.next);
        System.out.println(listNode);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
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