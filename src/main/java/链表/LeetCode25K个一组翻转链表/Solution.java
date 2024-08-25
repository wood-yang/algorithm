package 链表.LeetCode25K个一组翻转链表;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        int k = scanner.nextInt();
        ListNode listNode = new Solution().reverseKGroup(dummy.next, k);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (getLength(head) < k) {
            return head;
        }
        ListNode p = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }
        head.next = reverseKGroup(curr, k);

        return p;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
