package 链表.LeetCode234回文链表;


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

        boolean palindrome = new Solution().isPalindrome(head);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = null;
        while (head != null) {
            p2 = new ListNode(head.val, p2);
            head = head.next;
        }
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
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

    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
