import java.util.Arrays;

public class MaximumGap {

    public int maximumGap(int[] nums) {

        if ( nums.length < 2 )
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
// 3 3 6 6
        int gap = (int)Math.ceil(((double)max - min) / (nums.length - 1));

        int[] bucketMin = new int[nums.length];
        int[] bucketMax = new int[nums.length];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int i: nums){
            /*if (i == min || i == max)
                continue;*/
            int idx = (i - min) / gap;

            bucketMin[idx] = Math.min(bucketMin[idx], i);
            bucketMax[idx] = Math.max(bucketMax[idx], i);
        }

        int maxGap = 0;
        int left = min;

        for (int i = 0; i < nums.length - 1; i++){
            if (bucketMin[i] == Integer.MAX_VALUE)// && bucketMax[i] == Integer.MIN_VALUE)
                continue;

            maxGap = Math.max(maxGap, bucketMin[i] - left);
            left = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - left);

        return maxGap;

    }

    public static void main(String[] args) {
        MaximumGap DUT = new MaximumGap();
        System.out.println(DUT.maximumGap(new int[]{1,3,6,9}));
    }
}
