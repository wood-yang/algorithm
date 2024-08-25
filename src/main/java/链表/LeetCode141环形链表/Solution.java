package 链表.LeetCode141环形链表;

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
        boolean b = new Solution().hasCycle(pre.next);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
