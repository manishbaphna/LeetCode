import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class Pangram {

    // approach - 1
    public boolean checkIfPangram(String sentence) {
        for (Character ch='a'; ch <= 'z';++ch){
            if (sentence.indexOf(ch) == -1)
                return false;
        }

        return true;
    }

    // approach - 2
    public boolean checkIfPangram2(String sentence) {
        int Mask = 0x3FFFFFF;
        int bitmask = 0;

        for (int i=0; i < sentence.length(); ++i){
            bitmask |= 0x1 << (sentence.charAt(i) - 'a') ;
            if (bitmask == Mask)
                return true;
        }

        return false;
    }

    // approach - 3
    public boolean checkIfPangram3(String sentence) {
        Set<Character> alphabets = new HashSet<>();

        for (int i=0; i < sentence.length(); ++i){
            alphabets.add(sentence.charAt(i));
            if (alphabets.size() == 26)
                return true;
        }

        return false;

    }
}
