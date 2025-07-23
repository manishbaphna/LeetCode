//https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/

class LargetSqInsideTwoRect {

    public long computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        if ( bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2)
            return 0;

        long OLX = Math.max(ax1, bx1);
        long OLY = Math.max(by1, ay1);

        long ORX = Math.min(bx2, ax2);
        long ORY = Math.min(ay2, by2);

        long sqEdge = Math.min((ORX - OLX) , (ORY - OLY) );

        return sqEdge * sqEdge;
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;

        for ( int i=0; i <bottomLeft.length; ++i){
            int ax1 = bottomLeft[i][0];
            int ay1 = bottomLeft[i][1];
            int ax2 = topRight[i][0];
            int ay2 = topRight[i][1];

            for ( int j=i+1; j <bottomLeft.length; ++j){
                int bx1 = bottomLeft[j][0];
                int by1 = bottomLeft[j][1];
                int bx2 = topRight[j][0];
                int by2 = topRight[j][1];

                maxArea = Math.max( maxArea, computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
            }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [][] bottomLeft = {{1,1},{2,2},{1,2}};
        int [][] topRight = {{3,3},{4,4},{3,4}};

        LargetSqInsideTwoRect DUT = new LargetSqInsideTwoRect();
        long result = DUT.largestSquareArea(bottomLeft, topRight);
        System.out.println(result);
    }

}