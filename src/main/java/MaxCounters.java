
// https://app.codility.com/demo/results/training2FPY7Q-H9P/
//
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MaxCounters {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int []B = new int[N];
        int max = 0;

        for (int i=0; i <A.length; ++i) {
            if (A[i] > 0 && A[i] <= N) {
                B[A[i] - 1] += 1;
                max = Math.max(max ,B[A[i] - 1]);
            } else if (A[i] == N + 1) {
                Arrays.fill(B, max);
            }
        }

        return B;
    }
}