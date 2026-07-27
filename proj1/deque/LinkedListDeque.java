package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        private T value;
        private Node next;
        private Node prev;

        public Node(T value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    private Node head;
    private Node last;
    private int size = 0;

    private class LLDequeIterator implements Iterator<T> {
        private int pos;
        private Node node;

        public LLDequeIterator() {
            pos = 0;
            node = head.next;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T ret = node.value;
            node = node.next;
            pos++;
            return ret;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LLDequeIterator();
    }

    public LinkedListDeque() {
        head = new Node(null);
        last = head;
        head.next = last;
        last.prev = head;
    }

    public void addFirst(T item) {
        Node node = new Node(item);
        Node old = head.next;
        node.prev = head;
        node.next = old;
        head.next = node;
        old.prev = node;

        if (size == 0) {
            last = node;
        }

        size++;
    }

    public void addLast(T item) {
        Node node = new Node(item);
        Node old = last;
        node.next = head;
        node.prev = old;
        old.next = node;
        head.prev = node;
        last = node;

        size++;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node node = head.next;
        while (head.next != null && node != head) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node old = head.next;
        T value = old.value;

        head.next = old.next;
        old.next.prev = head;

        if (old == last) {
            last = head;
        }

        old.next = null;
        old.prev = null;

        size--;

        return value;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node old = last;
        Node newLast = last.prev;
        T value = old.value;

        newLast.next = head;
        head.prev = newLast;
        last = newLast;

        old.prev = null;
        old.next = null;

        size--;
        return value;
    }

    public T get(int index) {
        if (index >= size && size <= 0) {
            return null;
        }

        int i = 0;
        Node node = head.next;
        while (node != head) {
            if (i == index) {
                return node.value;
            }
            i++;
            node = node.next;
        }

        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LinkedListDeque<T> other = (LinkedListDeque<T>) o;

        if (this.size != other.size) {
            return false;
        }

        for (int i = 0;i < size;i++) {
            T thisItem = this.get(i);
            Object otherItem = other.get(i);

            if (thisItem == null && otherItem == null) continue;
            if (thisItem == null || otherItem == null) return false;
            if (!thisItem.equals(otherItem)) return false;
        }
        return true;
    }

    private T recursive(int index, Node curHead) {
        if (index == 0) {
            return curHead.next.value;
        }

        return recursive(index - 1, curHead.next);
    }

    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        }

        if (index < 0 || index >= size) {
            return null;
        }

        return recursive(index, head);
    }
}
