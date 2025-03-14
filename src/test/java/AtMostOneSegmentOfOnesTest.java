import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AtMostOneSegmentOfOnesTest {
    AtMostOneSegmentOfOnes DUT = new AtMostOneSegmentOfOnes();

    private static Stream<Arguments> getTestInputs() {
        return Stream.of(
                Arguments.of("1", true),
                Arguments.of("10", true),
                Arguments.of("010", true),
                Arguments.of("110", true),
                Arguments.of("1001",false),
                Arguments.of("110110", false)

        );
    }

    @ParameterizedTest
    @MethodSource("getTestInputs")
    void basicTests(String input, boolean result){
        assertEquals(result, DUT.checkOnesSegment(input));
    }

}