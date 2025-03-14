//https://leetcode.com/problems/largest-odd-number-in-string/
public class LargestOddNumInString {

    boolean isOdd(int x) {
        return (x & 0x1) != 0;
    }
    public String largestOddNumber(String num) {

        for (int i = num.length() - 1 ; i >=0; --i) {
            if ( isOdd(num.charAt(i) - '0')) {
                return num.substring(0, i+1);
            }
        }

        return "";
    }
}
