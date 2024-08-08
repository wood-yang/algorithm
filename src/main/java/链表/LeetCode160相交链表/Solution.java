package 链表.LeetCode160相交链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ListNode preA = new ListNode(-1);
        ListNode preB = new ListNode(-1);
        ListNode preC = new ListNode(-1);
        Scanner scanner = new Scanner(System.in);

        ListNode p;
        p = preC;
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }

        p = preA;
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        p.next = preC.next;

        p = preB;
        int b = scanner.nextInt();
        for (int i = 0; i < b; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        p.next = preC.next;

        ListNode node = new Solution().getIntersectionNode(preA.next, preB.next);
        System.out.println(node);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

