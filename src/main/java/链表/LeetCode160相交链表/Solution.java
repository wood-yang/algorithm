package 链表.LeetCode160相交链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode headA = null;
        ListNode headB = null;
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            if (i == 0) {
                headA = headB = node;
            }
            else {
                node.next = headA;
                headA = headB = node;
            }
        }
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            node.next = headA;
            headA = node;
        }
        int b = scanner.nextInt();
        for (int i = 0; i < b; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            node.next = headB;
            headB = node;
        }

        ListNode node = new Solution().getIntersectionNode(headA, headB);
        System.out.println(node);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            }
            else {
               pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            }
            else {
                pB = pB.next;
            }
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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

