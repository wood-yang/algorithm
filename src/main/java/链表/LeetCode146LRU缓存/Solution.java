package 链表.LeetCode146LRU缓存;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);

        lruCache.get(4);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(1);

        lruCache.put(5, 5);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(5);
    }
}

class LRUCache {
    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, LinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    LinkedNode head;
    LinkedNode tail;

    // 初始化方法
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    // 取值的方法
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    // 存值的方法
    public void put(int key, int value) {
        LinkedNode newNode = new LinkedNode(key, value);
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        }
        else {
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
        }
        if (size > capacity) {
            LinkedNode removeNode = removeTail();
            cache.remove(removeNode.key);
            size--;
        }
    }
    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(LinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        head.next.prev = node;
    }
    private LinkedNode removeTail() {
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
