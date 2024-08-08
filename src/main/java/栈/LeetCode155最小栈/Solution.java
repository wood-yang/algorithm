package 栈.LeetCode155最小栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

}

class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> min;

    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        if (min.isEmpty() || val <= min.getLast()) {
            min.add(val);
        }
        stack.add(val);
    }

    public void pop() {
        Integer last = stack.removeLast();
        if (min.getLast().equals(last)) {
            min.removeLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
