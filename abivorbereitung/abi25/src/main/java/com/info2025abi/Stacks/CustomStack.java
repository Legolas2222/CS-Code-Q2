package com.info2025abi.Stacks;

public class CustomStack<ContentType> {

    private StackNode<ContentType> pointer;

    private class StackNode<NodeContentType> {
        private NodeContentType content;
        private StackNode<NodeContentType> next;

        public StackNode<NodeContentType> getNext() {
            return next;
        }

        public void setNext(StackNode<NodeContentType> next) {
            this.next = next;
        }

        public StackNode(NodeContentType pContent) {
            this.content = pContent;
            this.next = null;
        }

        public NodeContentType getContent() {
            return this.content;
        }

    }

    public CustomStack() {
        this.pointer = null;
    }

    public ContentType top() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.pointer.getContent();
        }
    }

    public boolean isEmpty() {
        return this.pointer == null;
    }

    public void push(ContentType pContent) {
        if (pContent == null) {
            return;
        }   
        StackNode<ContentType> node = new StackNode<ContentType>(pContent);
        if (this.isEmpty()) {
            this.pointer = node;
        }
        else {
            node.setNext(this.pointer);
            this.pointer = node;
        }
    }
    public void pop() {
        if (this.isEmpty()) {
            return;
        }
        StackNode<ContentType> current = this.pointer;
        this.pointer = current.getNext();
    }
}
