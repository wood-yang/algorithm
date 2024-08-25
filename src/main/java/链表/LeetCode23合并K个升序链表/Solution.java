package 链表.LeetCode23合并K个升序链表;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                p.next = new ListNode(scanner.nextInt());
                p = p.next;
            }
            lists[i] = dummy.next;
        }
        ListNode listNode = new Solution().mergeKLists(lists);
    }

    PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
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