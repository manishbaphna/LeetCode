import java.util.Arrays;

//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class NumMatrix {
    int [][]sums;

    void printSums() {
        for (int i= 0; i <sums.length; ++i) {
            for (int j=0; j < sums[0].length ; ++j) {
                System.out.print(sums[i][j] +",");
            }
            System.out.println();
        }
    }
    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length];

        // 1st column
        sums[0][0] = matrix[0][0];
        for (int i=1; i < matrix.length; ++i){
            sums[i][0] = matrix[i][0] + sums[i-1][0];
        }

        //1st row
        for (int i=1; i < matrix[0].length; ++i){
            sums[0][i] = matrix[0][i] + sums[0][i-1];
        }

        for (int i= 1; i <matrix.length; ++i) {
            for (int j=1; j < matrix[0].length ; ++j) {
                sums[i][j] = matrix[i][j] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if ( row1 > 0 && col1 > 0)
            return sums[row2][col2]  - (sums[row1-1][col2] + sums[row2][col1-1]) + sums[row1-1][col1-1];
        if ( row1 == 0 && col1 == 0)
            return sums[row2][col2];
        if ( row1 == 0)
            return sums[row2][col2]  - (sums[row2][col1-1]);

        return sums[row2][col2]  - (sums[row1-1][col2]);
    }

    public static void main(String[] args) {
        int [][] matrix = {{-4, -5}};
        NumMatrix dut = new NumMatrix(matrix);
        dut.printSums();
        int sum = dut.sumRegion(0,0,0,1);
        System.out.println(sum);

    }

}
