package main.java;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * @date 22/12/2018
 */
public class ImplementQueueusingStacks {
    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();
        while (stack.size() != 0) {
            tempStack.add(stack.pop());
        }
        tempStack.add(x);
        while (tempStack.size() != 0) {
            stack.add(tempStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ImplementQueueusingStacks obj = new ImplementQueueusingStacks();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.peek());


    }
}
