import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PangramTest {

    Pangram DUT = new Pangram();

    private static Stream<Arguments> getTestInputs() {
        return Stream.of(
                Arguments.of("thequickbrownfoxjumpsoverthelazydog", true),
                Arguments.of("leetcode",false),
                Arguments.of("sffwesdsssgsdfew", false)

        );
    }

    @ParameterizedTest
    @MethodSource("getTestInputs")
    void basicTests(String input, boolean result){
        assertEquals(result, DUT.checkIfPangram(input));
    }

    @Test
    void basicTests2(){
        String s = "1011";
        System.out.println(Arrays.toString(s.getBytes()));

        int k = 255;
        System.out.println(Integer.toBinaryString(k));
    }

}