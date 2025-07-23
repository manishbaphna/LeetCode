import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestUniqueStringTest {

    @Test
    void basicTest() {
        LargestUniqueString DUT = new LargestUniqueString();
        assertEquals(1, DUT.largestUniqueString("a"));
        assertEquals(2, DUT.largestUniqueString("ab"));
        assertEquals(8, DUT.largestUniqueString("abcdefgh"));
        assertEquals(6, DUT.largestUniqueString("abcdefa"));
        assertEquals(6, DUT.largestUniqueString("bacdefa"));

    }

}