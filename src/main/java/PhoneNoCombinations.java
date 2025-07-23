// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.*;

public class PhoneNoCombinations {

    HashMap<Integer, char[]> phoneNos;

    List<String> result = new ArrayList<>();
    PhoneNoCombinations() {
        char x = 'a' - 1;
        phoneNos = new HashMap<>( Map.of(
                2, new char[]{++x, ++x, ++x},
                3, new char[]{++x, ++x, ++x},
                4, new char[]{++x, ++x, ++x},
                5, new char[]{++x, ++x, ++x},
                6, new char[]{++x, ++x, ++x},
                7, new char[]{++x, ++x, ++x},
                8, new char[]{++x, ++x, ++x},
                9, new char[]{++x, ++x, ++x}
        ));
    }

    void impl(String digits, int index, String strSoFar) {
        if( index == digits.length()){
            result.add(strSoFar);
            return;
        }

        char[] alphas = phoneNos.get(digits.charAt(index) - '0');

        // or you can use this
        //char[] alphas = phoneNos.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
        for ( char c: alphas){
            impl(digits, index+1, strSoFar + c);
        }
    }
    public List<String> letterCombinations(String digits) {
        if ( digits == null || digits.isEmpty()) return result;
        String strSoFar = new String();
        impl(digits, 0, strSoFar);
        return result;
    }

    public static void main(String[] args) {
        PhoneNoCombinations phoneNoCombinations = new PhoneNoCombinations();
        //phoneNoCombinations.phoneNos.forEach((k,v) -> System.out.println(k + " : " + Arrays.toString(v)));
        //phoneNoCombinations.letterCombinations("23").forEach(System.out::println);
        phoneNoCombinations.letterCombinations("").forEach(System.out::println);
    }

}

