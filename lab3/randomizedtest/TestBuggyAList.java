package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correctLst = new AListNoResizing<>();
        BuggyAList<Integer> buggyLst = new BuggyAList<>();

        for (int i = 4; i <= 6; i++) {
            correctLst.addLast(i);
            buggyLst.addLast(i);
        }

        assertEquals(correctLst.size(), buggyLst.size());

        for (int i = 0; i < 3; i++) {
            assertEquals(correctLst.removeLast(), buggyLst.removeLast());
            assertEquals(correctLst.size(), buggyLst.size());
        }
    }

    @Test
    public void randomizeTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        int N = 5000;
        for (int i = 0;i < N;i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                buggy.addLast(randVal);
                assertEquals(correct.size(), buggy.size());
                assertEquals(correct.getLast(), buggy.getLast());
            } else if (operationNumber == 1) {
                int size1 = correct.size();
                int size2 = buggy.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2 && correct.size() > 0) {
                int last1 = correct.getLast();
                int last2 = buggy.getLast();
                assertEquals(last1, last2);
            } else if (operationNumber == 3 && correct.size() > 0) {
                int last1 = correct.removeLast();
                int last2 = buggy.removeLast();
                assertEquals(correct.size(), buggy.size());
                assertEquals(last1, last2);
            }
        }
    }
}
