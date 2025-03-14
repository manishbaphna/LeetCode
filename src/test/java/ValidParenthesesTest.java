import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    ValidParentheses DUT = new ValidParentheses();

    private static Stream<Arguments> getParenthesesCases() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("()", true),
                Arguments.of("{}", true),
                Arguments.of("[]", true),
                Arguments.of("{}}", false),
                Arguments.of("{{}", false),
                Arguments.of("{{}}", true),
                Arguments.of("{{}}]", false),
                Arguments.of("[{{}}]", true),
                Arguments.of("){{}}", false),
                Arguments.of("(){{}}", true),
                Arguments.of("()[]{{}}", true),
                Arguments.of("}{", false),
                Arguments.of("]]]]]]", false),
                Arguments.of("[[[[]]]]]]]]]]", false),
                Arguments.of("[[[[[[]]]]]]", true)
        );
    }

    @ParameterizedTest
    @MethodSource("getParenthesesCases")
    void simpleTestsForValidCases(String s, Boolean result){
        assertEquals(DUT.isValid(s), result);
    }
}