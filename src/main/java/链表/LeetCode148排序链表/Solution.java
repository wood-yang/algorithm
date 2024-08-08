package 链表.LeetCode148排序链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        new Solution().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode dummyHead = new ListNode(-1, head);
        for (int subLength = 1; subLength <= length; subLength <<= 1) {
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //确定head2的头节点
                ListNode head2 = curr.next;
                //让head1的末尾指向null, 而不是head1链表后面的节点
                curr.next = null;
                //继续遍历head2
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                //如果遍历完head2链表后, 后续不为空, 则将next赋为head2尾节点的下一个节点
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                //合并两个链表, 并且将合并后的头节点 拼在prev的后面, 遍历prev
                ListNode merge = merge(head1, head2);
                prev.next = merge;
                //prev为当前已 合并 后的链表的最后一个节点
                while (prev.next != null) {
                    prev = prev.next;
                }
                //next为未合并的链表的第一个节点
                curr = next;
            }
        }
        return dummyHead.next;
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            return new ListNode(l1.val, merge(l1.next, l2));
        }
        else {
            return new ListNode(l2.val, merge(l1, l2.next));
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
