//https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
public class AscendingNumbersInSentence {
    public boolean areNumbersAscending(String s) {
        var tokens = s.split(" ");

        int last = -1;

        for ( var w: tokens) {
            //System.out.println(w);

            try {
                int nextVal = Integer.valueOf(w);

                if (nextVal <= last)
                    return false;

                last = nextVal;
            } catch ( NumberFormatException e) {
                continue;
            }
        }

        return true;
    }
}
