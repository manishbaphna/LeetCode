import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AscendingNumbersInSentenceTest {
    AscendingNumbersInSentence DUT = new AscendingNumbersInSentence();

    @Test
    void basicTest() {
        assertTrue(DUT.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        assertFalse(DUT.areNumbersAscending("1 box has 3 blue 4 red 1 green and 12 yellow marbles"));
        assertFalse(DUT.areNumbersAscending("hello world 5 x 5"));
        assertFalse(DUT.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }

}