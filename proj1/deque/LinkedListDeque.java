package deque;

public class LinkedListDeque<T>/* implements Iterable<T>*/ {
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

    public boolean isEmpty() {
        return size == 0;
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
        while (head.next != null && node != head) {
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
        return false;
    }
}
