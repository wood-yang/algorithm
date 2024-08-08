package 链表.LeetCode23合并K个升序链表;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode head = null;
            ListNode tail = null;
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                ListNode node = new ListNode(scanner.nextInt());
                if (head == null) {
                    head = tail = node;
                }
                else {
                    tail.next = node;
                    tail = tail.next;
                }
            }
            lists[i] = head;
        }
        new Solution().mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
        }
        else {
            return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
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