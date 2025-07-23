
// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
class BinaryGap {
    public int solution(int N) {
        // Implement your solution here

        int gap = 0;
        int localGap = 0;
        boolean startCounting = false;
        while ( N != 0 ) {
            int lastBit = N & 1;

            if ( lastBit == 1){
                if (localGap>0) {
                    gap = Math.max(gap, localGap);
                    localGap = 0;
                } else {
                    startCounting = true;
                }
            } else {
                if ( startCounting ){
                    localGap++;
                }
            }

            N >>= 1;
        }

        return gap;
    }
}