package deque;

import org.junit.Test;

import java.util.Comparator;
import static org.junit.Assert.*;

class Student {
    private String name;
    private int age;
    private int scores;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScores() {
        return scores;
    }

    public Student(String name, int age, int scores) {
        this.name = name;
        this.age = age;
        this.scores = scores;
    }
}

public class MaxArrayDequeTest {
    public static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return x.compareTo(y);
        }
    }

    public static class StudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class StudentAgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    public static class StudentScoreComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return (int) ( o1.getScores() - o2.getScores());
        }
    }

    @Test
    public void test() {
        Comparator<Integer> c = new IntegerComparator();
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(c);
        deque.addLast(5);
        deque.addLast(10);
        deque.addLast(8);
        deque.addLast(9);
        assertEquals(10, (long) deque.max());
    }

    @Test
    public void testStudent() {
        Comparator<Student> nameComparator = new StudentNameComparator();
        Comparator<Student> ageComparator = new StudentAgeComparator();
        Comparator<Student> scoreComparator = new StudentScoreComparator();

        MaxArrayDeque<Student> deque = new MaxArrayDeque<>(nameComparator);
        deque.addLast(new Student("A", 15, 99));
        deque.addLast(new Student("C", 14, 98));
        deque.addLast(new Student("B", 16, 75));
        deque.addLast(new Student("F", 19, 66));

        assertEquals("F", deque.max().getName());
        assertEquals(19, deque.max(ageComparator).getAge());
        assertEquals(99, deque.max(scoreComparator).getScores());

    }
}