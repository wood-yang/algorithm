package 链表.LeetCode148排序链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        new Solution().sortList(dummy.next);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        for (int subLength = 1; subLength <= length; subLength <<= 1) {
            //如果curr为null，说明此次合并已经完成，进行下一次合并
            while (curr != null) {
                ListNode head1 = curr;
                //确定head1的尾节点
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //确定head2的头节点
                ListNode head2 = curr.next;
                //确定好了之后，让head1的尾节点指向null
                curr.next = null;
                //继续遍历head2，确定head2的尾节点
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                //保存head2尾节点后面的节点
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge(head1, head2);
                //遍历prev到当前已合并链表的最后一个节点
                //此处不能直接prev = curr，因为curr可能为null
                while (prev.next != null) {
                    prev = prev.next;
                }
                //next 是未合并链表的第一个节点
                curr = next;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1.next;
                l1 = l1.next;
            }
            else {
                p.next = l2.next;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        }
        else {
            p.next = l1;
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
