package 链表.LeetCode206反转链表;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ListNode pre = new ListNode(-1);
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ListNode p = pre;
        for (int i = 0; i < a; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        ListNode listNode = new Solution().reverseList(pre.next);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
