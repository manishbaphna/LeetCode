import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        Stack<StringBuilder> stStr = new Stack<>();
        Stack<Integer> stInt = new Stack<>();
        StringBuilder pattern = new StringBuilder();

        int num = 0;

        for ( Character ch : s.toCharArray()) {

            if (Character.isLetter(ch)) {
                pattern.append(ch);
            } else if ( Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if ( ch == '[') {
                if ( num != 0)
                    stInt.push(num);
                stStr.push(pattern);
                pattern = new StringBuilder();
                num = 0;

            } else if ( ch == ']') {
                int count = stInt.pop();
                StringBuilder temp = stStr.isEmpty() ? new StringBuilder() : stStr.pop();
                for (int k=0; k<count; ++k) {
                    temp.append(pattern);
                }
                num = 0;
                pattern = temp;
            }

        }

        return pattern.toString();
        //return Helper(s, 0).getLeft();
    }

    private Pair<String, Integer> Helper(String s, int index) {

        int num = 0;
        int charUsed = 0;
        StringBuilder pattern = new StringBuilder();

        for (int i=index; i <s.length(); ++i) {
            Character ch = s.charAt(i) ;

            if (Character.isLetter(ch)) {
                pattern.append(ch);
            } else if ( Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if ( ch == '[') {
                Pair<String, Integer> toExpand = Helper(s, 1+i);
                for (int k=0; k<num; ++k) {
                    pattern.append(toExpand.getLeft());
                }
                num = 0;
                i += toExpand.getRight();
            } else if ( ch == ']') {
                return new Pair<String, Integer>(pattern.toString(), 1+ i - index);
            }
        }

        return new Pair<String, Integer>(pattern.toString(), s.length() - index);

    }

    public static void main(String[] args) {
        DecodeString dut = new DecodeString();
        String res = dut.decodeString("3[a2[c]]");
       // assertEquals("accaccacc", res);
        System.out.println(res );
    }
}
