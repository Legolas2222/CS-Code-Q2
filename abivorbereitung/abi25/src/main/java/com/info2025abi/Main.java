package com.info2025abi;

import com.info2025abi.Stacks.CustomStack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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
}