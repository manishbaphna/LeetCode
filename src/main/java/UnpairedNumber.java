import java.util.HashSet;

// https://leetcode.com/problems/single-number/
public class UnpairedNumber {
    public int singleNumber(int[] A) {
        HashSet<Integer> pairedNums = new HashSet<>();

        int result = A[0];

        for (int i=1; i<A.length; ++i){

            result ^= A[i];
        }


        return result;

    }
}
