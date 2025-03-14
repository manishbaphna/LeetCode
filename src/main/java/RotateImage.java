public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null )
            return;

        int N = matrix[0].length;
        int offset = N - 1;

        int loopCount = N - 1;
        int col = N - 1;

        for (int i=0; i< N - 1; ++i) {
            matrix[i+offset][col] = matrix[i][N - col -1];
        }
    }
}
