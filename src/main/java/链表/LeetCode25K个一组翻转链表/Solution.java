package 链表.LeetCode25K个一组翻转链表;

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
        int k = scanner.nextInt();
        ListNode listNode = new Solution().reverseKGroup(pre.next, k);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p == null) {
                return head;
            }
            else {
                p = p.next;
            }
        }
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            if (i == 0) {
                p = pre;
            }
            if (i == k - 1) {
                p.next = reverseKGroup(next, k);
            }
            cur = next;
        }

        return pre;
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
