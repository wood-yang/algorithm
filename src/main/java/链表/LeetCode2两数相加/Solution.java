package 链表.LeetCode2两数相加;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode pre1 = new ListNode(-1);
        ListNode pre2 = new ListNode(-1);
        ListNode p;

        p = pre1;
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }

        p = pre2;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }

        ListNode listNode = new Solution().addTwoNumbers(pre1.next, pre2.next);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }
        return pre.next;
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
