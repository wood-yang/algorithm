package 堆.LeetCode295数据流的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

}

class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queMax = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMin.size() > queMax.size() + 1) {
                queMax.offer(queMin.poll());
            }
        }
        else {
            queMax.offer(num);
            if (queMin.size() < queMax.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        else {
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
