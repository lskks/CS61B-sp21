package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size = 0;

    public ArrayDeque() {
        items = (T[]) new Object[100];
    }

    public void addFirst(T val) {
        for (int i = 0;i < size;i++) {
            items[i+1] = items[i];
        }
        items[0] = val;
        size++;
    }

    public void addLast(T val) {
        items[size] = val;
        size++;
    }

    public T removeFirst() {
        T val = items[0];

        for (int i = 0;i < size - 1;i++) {
            items[i] = items[i + 1];
        }
        size--;
        return val;
    }

    public T removeLast() {
        T val = items[size--];
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = 0;i < size;i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
