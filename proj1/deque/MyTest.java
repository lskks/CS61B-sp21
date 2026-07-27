package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyTest {
    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(10);
        lst.addFirst(20);
        lst.addFirst(30);
        lst.addFirst(40);
        lst.addFirst(50);
        lst.printDeque();
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addLast(10);
        lst.addLast(20);
        lst.addLast(30);
        lst.addLast(40);
        lst.addLast(50);
        lst.printDeque();
    }

    @Test
    public void testEmpty() {
        LinkedListDeque<Integer> lst1 = new LinkedListDeque<>();
        assertTrue(lst1.isEmpty());
        LinkedListDeque<Integer> lst2 = new LinkedListDeque<>();
        lst2.addLast(10);
        assertFalse(lst2.isEmpty());

    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(10);
        lst.addFirst(20);
        lst.addFirst(30);
        lst.addFirst(40);
        lst.addFirst(50);

        lst.removeFirst();
        lst.printDeque();
        lst.removeFirst();
        lst.printDeque();
    }

    @Test
    public void testArrayAddFirst() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(10);
        arr.addFirst(20);
        arr.addFirst(30);
        arr.addFirst(40);
        arr.addFirst(50);
        arr.addFirst(60);
        arr.addFirst(70);
        arr.addFirst(80);
        arr.printDeque();
    }

    @Test
    public void testArrayAddLast() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(10);
        arr.addLast(20);
        arr.addLast(30);
        arr.addLast(40);
        arr.addLast(50);
        arr.addLast(60);
        arr.addLast(70);
        arr.addLast(80);
        arr.printDeque();
    }

    @Test
    public void testArrayRemoveFirst() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(10);
        arr.addLast(20);
        arr.addFirst(30);
        arr.addFirst(40);

        arr.printDeque();

        arr.removeFirst();
        arr.printDeque();
        arr.removeFirst();
        arr.printDeque();
        arr.removeFirst();
        arr.printDeque();
    }

    @Test
    public void testArrayResize() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(10);
        arr.addLast(20);
        arr.addLast(30);
        arr.addLast(40);
        arr.addLast(50);
        arr.addLast(60);
        arr.addLast(70);
        arr.addLast(80);
        arr.printDeque();

        arr.addFirst(90);
        arr.printDeque();
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test1() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println(deque.get(0));  // 应该是0
        System.out.println(deque.get(1));  // 应该是1
        System.out.println(deque.get(2));  // 应该是2
    }
}
