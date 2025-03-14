import java.util.Stack;
// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
public class CheckIfParenthesesCanBeValid {
    int index = 0;


    boolean isValid(String s) {

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
    private boolean canBeValidImpl(StringBuilder s, String locked, int position) {

        for (int i=position; i <locked.length();++i){
            if ( locked.charAt(i) == '1')
                continue;

            StringBuilder sCopy = new StringBuilder(s);
            sCopy.setCharAt(i, s.charAt(i) == ')' ? '(' : ')');
            return canBeValidImpl(s, locked, 1+position) || canBeValidImpl(sCopy, locked, 1+position);
        }

        System.out.println(index++ + "Trying :" + s);
        return isValid(String.valueOf(s));
    }

    public boolean canBeValid(String s, String locked) {

        if (s.length() % 2 != 0 || s.length() != locked.length()) //odd length string
            return false;

        StringBuilder sMutable = new StringBuilder(s);
        return canBeValidImpl(sMutable, locked, 0);
    }

}
