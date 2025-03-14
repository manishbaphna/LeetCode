// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/
public class AtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {

        int occurrence = 0;

        for (int i=0; i<s.length(); ++i){
            Character c = s.charAt(i);

            if ( c == '1') {
                occurrence += occurrence % 2 == 0 ? 1 : 0;
            } else {
                occurrence += occurrence == 1 ? 1 : 0;
            }

            if ( occurrence == 3)
                return false;
        }
        return true;

    }

}
