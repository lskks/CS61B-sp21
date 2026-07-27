package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size = 0;
    private int first;
    private int last;
    private int capacity = 8;

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;
        private int cnt;

        ArrayDequeIterator() {
            pos = (first + 1) % capacity;
            cnt = 0;
        }

        @Override
        public boolean hasNext() {
            return cnt < size;
        }

        @Override
        public T next() {
            T ret = items[pos];
            pos = (pos + 1) % capacity;
            cnt++;
            return ret;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof Deque)) {
            return false;
        }

        Deque<T> other = (Deque<T>) o;

        if (this.size() != other.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        first = 3;
        last = 4;
    }


    private T[] getArray() {
        T[] arr = (T[]) new Object[capacity];
        for (int i = (first + 1) % capacity, j = 0; j < size; i = (i + 1) % capacity, j++) {
            arr[j] = items[i];
        }
        return arr;
    }

    private void resize(int length) {
        T[] arr = getArray();
        T[] newArr = (T[]) new Object[length];

        System.arraycopy(arr, 0, newArr, 1, size);
        first = 0;
        last = size + 1;
        items = newArr;
        capacity = length;
    }

    public void addFirst(T val) {
        if (size >= capacity) {
            resize(capacity * 2);
        }
        items[first] = val;
        first = (first - 1 + capacity) % capacity;
        size++;
    }

    public void addLast(T val) {
        if (size >= capacity) {
            resize(capacity * 2);
        }
        items[last] = val;
        last = (last + 1) % capacity;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        first = (first + 1) % capacity;
        T val = items[first];
        size--;

        if (size <= capacity * 0.25 && capacity >= 16) {
            resize((int) Math.round(capacity * 0.5));
        }

        return val;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        last = (last - 1 + capacity) % capacity;
        T val = items[last];
        size--;

        if (size <= capacity * 0.25 && capacity >= 16) {
            resize((int) Math.round(capacity * 0.5));
        }

        return val;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (size <= 0 || index >= size) {
            return null;
        }

        return items[(first + index + 1) % capacity];
    }

    public void printDeque() {
        for (T i : this) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
