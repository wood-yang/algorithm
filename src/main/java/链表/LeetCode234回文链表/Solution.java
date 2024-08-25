package 链表.LeetCode234回文链表;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ListNode pre = new ListNode();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ListNode p = pre;
        for (int i = 0; i < a; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        boolean palindrome = new Solution().isPalindrome(pre.next);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode halfHead = reserveList(mid.next);

        boolean result = true;
        ListNode p1 = head;
        ListNode p2 = halfHead;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        mid.next = reserveList(halfHead);

        return result;
    }

    private ListNode reserveList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
