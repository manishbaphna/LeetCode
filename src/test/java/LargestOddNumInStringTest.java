import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LargestOddNumInStringTest {

    LargestOddNumInString DUT = new LargestOddNumInString();

    private static Stream<Arguments> getTestInputs() {
        return Stream.of(
                Arguments.of("52", "5"),
                Arguments.of("4206", ""),
                Arguments.of("35427", "35427"),
                Arguments.of("35427234", "3542723"),
                Arguments.of("7542351161", "7542351161")
        );
    }

    @ParameterizedTest
    @MethodSource("getTestInputs")
    void basicTests(String input, String result){
        assertEquals(result, DUT.largestOddNumber(input));
    }

}