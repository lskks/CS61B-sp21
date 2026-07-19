package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void test() throws Exception {
        boolean sameNumber = Flik.isSameNumber(256, 256);
        assertTrue("The 256 is not equal to 256", sameNumber);
    }
}
