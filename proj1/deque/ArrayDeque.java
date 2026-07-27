package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T> {
    private T[] items;
    private int size = 0;
    int first;
    int last;
    int capacity = 8;

    private class ArrayDequeIterator implements Iterator<T> {
        int pos;
        int cnt;

        public ArrayDequeIterator() {
            pos = first + 1;
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

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArrayDeque<T> other = (ArrayDeque<T>) o;

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
        for (int i = first + 1, j = 0;j < size;i = (i + 1) % capacity, j++) {
            arr[j] = items[i];
        }
        return arr;
    }

    private void resize(int length) {
        T[] arr = getArray();
        T[] newArr = (T[]) new Object[length];

        System.arraycopy(arr, 0, newArr, capacity / 2, size);
        first = capacity / 2 - 1;
        last = first + size + 1;
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
        return val;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        last = (last - 1 + capacity) % capacity;
        T val = items[last];
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
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
//        for (int i = first + 1, j = 0;j < size;i = (i + 1) % capacity, j++) {
        for (T i : this) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
