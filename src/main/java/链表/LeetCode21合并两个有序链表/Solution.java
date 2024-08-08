package 链表.LeetCode21合并两个有序链表;

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
        ListNode listNode = new Solution().mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
        else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
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
