//    https://leetcode.com/problems/largest-3-same-digit-number-in-string/
public class Largest3DigitsNum {
    public String largestGoodInteger(String num) {
        int ret = -1;

        for (int i=0; i + 2 < num.length() ; i++) {
            if ( num.charAt(i) == num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)) {
                ret = Math.max(ret, convertCharToInt(num.charAt(i)));
            }
        }

        return ret == -1 ? "" : String.valueOf(ret);

    }

    private int convertCharToInt(char c) {
        int val = c - '0';
        val = (val * 100) + (val * 10) + val;
        return val;
    }
}
