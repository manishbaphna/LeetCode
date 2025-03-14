import java.util.ArrayList;
import java.util.Arrays;

/*
Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
We define a token to be one or more consecutive English alphabetic letters.
 */
public class StringTokens {

    static String[] convertStringIntoTokens(String s, String regex) {
        s = s.trim();
        String[] tokens = s.split(regex);
        System.out.println(Arrays.toString(tokens));
        return tokens;
    }

    public static void main( String []args) {
        String s = "";
        var results = convertStringIntoTokens(s, "[!,?._'@ ]+");
        System.out.println(results.length);
        
    }

}
