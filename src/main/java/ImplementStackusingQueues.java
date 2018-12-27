package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ImplementStackusingQueues {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackusingQueues() {
        queue = new LinkedBlockingQueue<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> tempQueue = new LinkedBlockingQueue<>();
        tempQueue.add(x);
        while (queue.size() != 0) {
            tempQueue.add(queue.poll());
        }
        queue = tempQueue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackusingQueues stack = new ImplementStackusingQueues();

        stack.push(1);
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false

    }
}
