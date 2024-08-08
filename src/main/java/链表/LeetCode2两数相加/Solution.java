package 链表.LeetCode2两数相加;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode list1 = null;
        ListNode list2 = null;
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            node.next = list1;
            list1 = node;
        }

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            node.next = list2;
            list2 = node;
        }

        ListNode listNode = new Solution().addTwoNumbers(list1, list2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            }
            else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
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
