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
    public void testArray() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(10);
        arr.addFirst(20);
        arr.addLast(30);
        arr.printDeque();
    }
}
