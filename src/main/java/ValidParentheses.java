
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
class ValidParentheses {
    public boolean isValid(String s) {

        if (s == null || s.isEmpty())
            return false;

        Stack<Character> stack = new Stack<>();
        final Character invalidChar = ' ';

        for( int i=0; i< s.length(); ++i) {
            Character c = s.charAt(i);

            if ( c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                Character lastChar = !stack.empty() ? stack.peek() : invalidChar;

                Boolean isValid = c == ')' ? lastChar == '(' :
                                 c == '}' ? lastChar == '{' :
                                 c == ']' && lastChar == '[';

                if (!isValid)
                    return false;

                stack.pop();
            }
        }

        return stack.empty();
    }
}