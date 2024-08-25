package 链表.LeetCode138随机链表的复制;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Node dummy = new Node(-1);
        Node p = dummy;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            p.next = node;
            p = p.next;
            list.add(node);
        }
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            int index = scanner.nextInt();
            if (index != -1) {
                node.random = list.get(index);
            }
        }
        new Solution().copyRandomList(dummy.next);
    }

/*
5
7 13 11 10 1
-1 0 4 2 0
*/

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = node.next;
            if (node.random != null) {
                newNode.random = node.random.next;
            }
        }
        Node dummy = new Node(-1);
        Node p = dummy;
        for (Node node = head; node != null; node = node.next) {
            p.next = node.next;
            p = p.next;
            node.next = node.next == null ? null : node.next.next;
        }
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
