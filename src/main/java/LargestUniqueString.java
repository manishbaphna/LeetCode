import java.util.HashMap;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LargestUniqueString {

    int largestUniqueString(String s){
        int start = 0;
        int maxLen = 0;
        HashMap<Character, Integer> lastPosition = new HashMap<>();

        if ( s.length() <= 1) {
            return s.length();
        }

        int i = 0;
        lastPosition.put(s.charAt(i), i);

        /* abc
        a: 0
        b: 1
        c: 2
        i = 3
        */
        for (i=1; i < s.length();++i ){
            Integer pos = lastPosition.get(s.charAt(i));
            if ( pos != null ) {
                if ( pos >= start) {
                    maxLen = Math.max(maxLen, i - start);
                    start = 1 + pos;
                }
            }
            lastPosition.put(s.charAt(i), i);
        }
        return Math.max(maxLen, i - start);
    }

    public static void main(String[] args) {
        LargestUniqueString DUT = new LargestUniqueString();
        System.out.println(DUT.largestUniqueString("ab"));

        //System.out.println(DUT.largestUniqueString("bacdaefb"));
    }
}
