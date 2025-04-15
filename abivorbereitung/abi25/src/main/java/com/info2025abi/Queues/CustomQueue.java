package com.info2025abi.Queues;

public class CustomQueue<ContentType> {
    private CustomQueueNode<ContentType> first;
    private CustomQueueNode<ContentType> last;

    private class CustomQueueNode<QueueNodeContentType> {

        private QueueNodeContentType content;

        public QueueNodeContentType getContent() {
            return content;
        }

        public void setContent(QueueNodeContentType content) {
            this.content = content;
        }

        private CustomQueueNode<QueueNodeContentType> next;

        public CustomQueueNode<QueueNodeContentType> getNext() {
            return next;
        }

        public void setNext(CustomQueueNode<QueueNodeContentType> next) {
            this.next = next;
        }

        public CustomQueueNode(QueueNodeContentType pContent) {
            this.content = pContent;
            this.next = null;
        }

    }

    public CustomQueue() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        if (this.first == null && this.last == null) {
            return true;
        }
        return false;
    }

    public ContentType front() {
        if (!this.isEmpty()) {
            return this.first.getContent();
        }
        return null;
    }

    public void enqueue(ContentType pContent) {
        if (pContent == null) {
            return;
        }
        if (this.isEmpty()) {
            CustomQueueNode<ContentType> node = new CustomQueueNode<ContentType>(pContent);
            this.first = node;
            this.last = node;
        } else {
            CustomQueueNode<ContentType> node = new CustomQueueNode<ContentType>(pContent);
            this.last.setNext(node);
            this.last = node;
        }
    }

    public void dequeue() {
        if (this.isEmpty()) {
            return;
        }
        
        if (this.first == this.last) {
            this.first = null;
            this.last = null;            }
        else {
            this.first = this.first.getNext();
        }
        
    }
}
