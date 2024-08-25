package 链表.LeetCode21合并两个有序链表;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode pre1 = new ListNode();
        ListNode pre2 = new ListNode();
        int m = scanner.nextInt();
        ListNode p = pre1;
        for (int i = 0; i < m; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }

        int n = scanner.nextInt();
        p = pre2;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        ListNode listNode = new Solution().mergeTwoLists(pre1.next, pre2.next);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            }
            else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 != null ? list1 : list2;
        return pre.next;
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
