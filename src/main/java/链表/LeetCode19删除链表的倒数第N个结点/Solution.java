package 链表.LeetCode19删除链表的倒数第N个结点;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = null;
        ListNode tail = null;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(scanner.nextInt());
            if (head == null) {
                head = tail = node;
            }
            else {
                tail.next = node;
                tail = tail.next;
            }
        }
        int k = scanner.nextInt();
        ListNode listNode = new Solution().removeNthFromEnd(head, k);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int length = getLength(head);
        //删除的节点在第index个, 从头节点遍历index前一个节点需要index-2次
        ListNode cur = dummy;
        for (int i = 1; i <= length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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
