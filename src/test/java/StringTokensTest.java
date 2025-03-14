import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTokensTest {


    @Test
    void test_oneOrMoreOccurrence_regex() {

        String s = "He is a very very good boy, isn't he?";
        String[] expected = {"He", "is","a","very","very","good","boy","isn","t","he"};
        String[] results = StringTokens.convertStringIntoTokens(s, "[!,?._'@ ]+");
        assertEquals(10, results.length);
        assertArrayEquals(expected, results);
    }

    @Test
    void test_zeroOrMoreOccurrence_regex() {

        String s = "isn't he?";
        String[] expected = {"i", "s","n","","t","","h","e"};
        String[] results = StringTokens.convertStringIntoTokens(s, "[' ?]*");   //"[!,?._'@ ]*
        assertEquals(8, results.length);
        assertArrayEquals(expected, results);


    }

    @Test
    void test_leadingSpaces() {

        String s = "           YES      leading spaces        are valid,    problemsetters are         evillllll";
        String[] expected = {"YES", "leading","spaces","are","valid","problemsetters","are","evillllll"};
        String[] results = StringTokens.convertStringIntoTokens(s, "[!,?._'@ ]+");
        assertEquals(8, results.length);
        assertArrayEquals(expected, results);
        for ( String k: results) {
            System.out.println(k);
        }
    }

    @Test
    void test_leadingWhiteSpaces() {

        String s = "       \n\n    YES      leading spaces        are valid,    problemsetters are         evillllll   ";
        String[] expected = {"YES", "leading","spaces","are","valid","problemsetters","are","evillllll"};
        String[] results = StringTokens.convertStringIntoTokens(s, "[!,?._'@ ]+");
        assertEquals(8, results.length);
        assertArrayEquals(expected, results);
        for ( String k: results) {
            System.out.println(k);
        }
    }

    @Test
    void test_emptyString() {

        String s = " ";
        String[] expected;
        String[] results = StringTokens.convertStringIntoTokens(s, "[!,?._'@ ]+");
        assertEquals(0, results.length);
        //assertArrayEquals(expected, results);
    }

}