/*

Toeplitz Matrix
A Toeplitz matrix is a matrix where every left-to-right-descending diagonal has the same element.
Given a non-empty matrix arr, write a function that returns true if and only if it is a Toeplitz matrix.
The matrix can be any dimensions, not necessarily square.

 */

public class ToeplitzMatrix {
    boolean isToeplitz(int[][] arr) {
        // your code goes here
        int R = arr.length;

        if ( R <= 0 )
            return R == 1;

        int C = arr[0].length;

        for (int i=1; i < R; ++i){
            for (int j=i; j<C; ++j){
                if ( arr[i][j] != arr[i-1][j-1])
                    return false;
            }
        }

        return true;

    }

    boolean isToeplitz2(int[][] arr) {
        // your code goes here
        int R = arr.length;

        if ( R <= 0 )
            return R == 1;

        int C = arr[0].length;

        for (int i=0; i < C; ++i){
            int val = arr[0][i];
            for (int j=1; (j < R) && (i + j ) < C; ++j){
                if ( val != arr[j][i+j])
                    return false;
            }
        }

        return true;

    }

}
