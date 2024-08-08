package 队列.LeetCode933最近的请求次数;

import java.util.LinkedList;

public class Solution {

}

class RecentCounter {
    LinkedList<Integer> deque;
    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        while (deque.getFirst() < t - 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}
