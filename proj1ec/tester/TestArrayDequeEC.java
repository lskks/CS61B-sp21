package tester;

import org.junit.Test;
import static org.junit.Assert.*;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;

public class TestArrayDequeEC {
    @Test
    public void randomizedTest() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        StringBuilder message = new StringBuilder();

        for (int i = 0;i < 1000;i++) {
            int choice = StdRandom.uniform(0, 5);
            int val = StdRandom.uniform(0, 100);

            if (choice == 0) {
                correct.addFirst(val);
                student.addFirst(val);
                message.append("addFirst(").append(val).append(")\n");
            } else if (choice == 1) {
                correct.addLast(val);
                student.addLast(val);
                message.append("addLast(").append(val).append(")\n");
            } else if (choice == 2 && !correct.isEmpty() && !student.isEmpty()) {
                message.append("size()\n");
                assertEquals(message.toString(), correct.size(), student.size());
                message.append("removeFirst()\n");
                assertEquals(message.toString(), correct.removeFirst(), student.removeFirst());
            } else if (!correct.isEmpty() && !student.isEmpty()){
                message.append("size()\n");
                assertEquals(message.toString(), correct.size(), student.size());
                message.append("removeLast()\n");
                assertEquals(message.toString(), correct.removeLast(), student.removeLast());
            }
        }
    }
}
