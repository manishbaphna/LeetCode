
import java.util.ArrayList;
import java.util.Arrays;

// Given two strings , confirm if they are anagram to each other, ignore case
public class Anagram {
    static boolean isAnagram3(String a, String b) {
        // Complete the function
        char[] a1 = a.toLowerCase().toCharArray();
        char[] b1 = b.toLowerCase().toCharArray();
        //System.out.println(a1.toString() + ":" + b1.toString());

        Arrays.sort(a1);
        Arrays.sort(b1);

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(b1));

        return Arrays.equals(a1, b1);
    }
    static boolean isAnagram(String a, String b) {
        // Complete the function

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        if ( a.length() != b.length())
            return false;

        for(int i=0; i< a.length(); ++i) {
            arr1[Character.toLowerCase(a.charAt(i)) - 'a'] += 1 ;
            arr2[Character.toLowerCase(b.charAt(i)) - 'a'] += 1 ;
        }

        for(int i=0; i <26;++i){
            if ( arr1[i] != arr2[i] )
                return false;
        }

        return true;
    }
    static boolean isAnagram2(String a, String b) {
        // Complete the function

        ArrayList<Integer> arr1 = new ArrayList<>(26);
        ArrayList<Integer> arr2 = new ArrayList<>(26);


        for(int i=0; i <26;++i){
            arr1.add(0);
            arr2.add(0);
        }

        for(int i=0; i< a.length(); ++i) {
            arr1.set(Character.toLowerCase(a.charAt(i)) - 'a', 1 + arr1.get(i));
            arr2.set(Character.toLowerCase(b.charAt(i)) - 'a', 1 + arr2.get(i));
        }
        return a.length() == b.length() && arr1.equals(arr2);
    }

    public static void main(String []args) {
        //boolean result = isAnagram("arc", "rac");
        //System.out.println("Result " + result);
       // result = isAnagram("arc", "raec");
        boolean result = isAnagram("ACT", "tac");

        System.out.println("Result " + result);

        return ;
    }
}
