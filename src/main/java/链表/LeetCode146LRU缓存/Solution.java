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
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode() {}
        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private Integer size;
    private Integer capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在, 先通过哈希表定位, 再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //如果key不存在, 创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            size++;
            if (size > capacity) {
                //如果超过容量, 删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            //如果key存在, 先通过哈希表定位, 在修改value, 并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next= head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
