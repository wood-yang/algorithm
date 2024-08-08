package 链表.LeetCode24两两交换链表中的节点;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        ListNode listNode = new Solution().swapPairs(pre.next);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next.next;
        head.next.next = head;
        head = head.next;
        head.next.next = swapPairs(temp);

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
