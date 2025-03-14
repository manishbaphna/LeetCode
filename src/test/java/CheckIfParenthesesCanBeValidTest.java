import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfParenthesesCanBeValidTest {
    CheckIfParenthesesCanBeValid DUT = new CheckIfParenthesesCanBeValid();

    private static Stream<Arguments> getParenthesesCases() {
        return Stream.of(
                Arguments.of("()()", "0000", true),
                Arguments.of(")", "0", false),
                Arguments.of("))()))", "010100", true),
                Arguments.of("))()))(())", "0000000000", true),
                Arguments.of("))()))(())", "1111111111", false),
                Arguments.of("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111", false)

        );
    }
    private static Stream<Arguments> getParenthesesCases1() {
        return Stream.of(
                //Arguments.of("))))", "0000", true)
                Arguments.of("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111", false)

        );
    }

    @ParameterizedTest
    @MethodSource("getParenthesesCases1")
    void simpleTestsForValidCases(String s, String locked, Boolean result){
        assertEquals(DUT.canBeValid(s, locked), result);
    }

}