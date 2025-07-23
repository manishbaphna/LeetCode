

// https://leetcode.com/problems/range-sum-query-2d-immutable/
// This is  more readable / better version than numMatrix

class NumMatrix2 {
    int [][] sum;//= new int [nRows+1][nCols+1];

    public NumMatrix2(int[][] matrix) {
        int nRows = matrix.length;
        if ( nRows == 0 )
            return;
        int nCols = matrix[0].length;

        // by default : Java initializes the array with 0
        sum = new int [nRows+1][nCols+1];

        for (int i = nRows - 1; i >=0; --i){
            for (int j=nCols-1; j>=0; --j){
                sum[i][j] = matrix[i][j] + sum[i][j+1] + sum[i+1][j] - sum[i+1][j+1];
                System.out.println("i=" + i + " j=" +j + " sum[i][j]=" + sum[i][j]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row1][col1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row2+1][col2+1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix2 obj = new NumMatrix2(matrix);
        int param_1 = obj.sumRegion(2,1,4,3);
        System.out.println(param_1);
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */