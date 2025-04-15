package com.info2025abi;

import com.info2025abi.Queues.CustomQueue;
import com.info2025abi.Stacks.CustomStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testStack();
        testQueue();
        
    }
    public static void testStack() {
        CustomStack<Integer> stack = new CustomStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top());
        stack.pop();
        System.out.println("Top element after pop: " + stack.top());
        stack.pop();
        System.out.println("Top element after pop: " + stack.top());
        stack.pop();
        System.out.println("Is stack empty? " + stack.isEmpty());
        stack.pop(); // Attempting to pop from an empty stack
            
    }
    public static void testQueue() {
        CustomQueue<Integer> queue = new CustomQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Front element: " + queue.front());
        queue.dequeue();
        System.out.println("Front element after dequeue: " + queue.front());
        queue.dequeue();
        System.out.println("Front element after dequeue: " + queue.front());
        queue.dequeue();
        System.out.println("Is queue empty? " + queue.isEmpty());
        queue.dequeue(); // Attempting to dequeue from an empty queue
    }
}