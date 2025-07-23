//https://leetcode.com/problems/first-missing-positive/description/

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class FirstPositiveNum {


    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public int solution(int[] A) {
        // Implement your solution here

        for (int i=0; i<A.length; ++i) {
            while ( A[i] != i+1  && A[i] <= A.length && A[i] > 0 && A[i] != A[A[i] -1] ) {
                swap(A, i, A[i] - 1);
            }
        }

        int index = 1;
        for (int i=0; i<A.length; ++i) {
            if ( A[i] <= 0) {
                continue;
            } else if ( A[i] == index) {
                index++;
            } else if ( A[i] != index) {
                return index;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,4,1};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        System.out.println("result = "+res);
    }
}
