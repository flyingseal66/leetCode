package main.java;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minNumbers;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minNumbers = new Stack<>();
        minNumbers.add(0);
    }

    public void push(int x) {
        stack.add(x);
        if (minNumbers.size() >0 && x > minNumbers.peek()) {
            minNumbers.add(minNumbers.peek());
        } else {
            minNumbers.add(x);
        }
    }

    public void pop() {
        stack.pop();
        minNumbers.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNumbers.pop();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

