package 链表.LeetCode138随机链表的复制;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Node head = null;
        Node tail = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Node node = new Node(scanner.nextInt());
            list.add(node);
            if (head == null) {
                head = tail = node;
            }
            else {
                tail.next = node;
                tail = tail.next;
            }
        }
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            int index = scanner.nextInt();
            if (index != -1) {
                node.random = list.get(index);
            }
        }
        new Solution().copyRandomList(head);
    }

    HashMap<Node, Node> cashedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cashedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cashedNode.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cashedNode.get(head);
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
