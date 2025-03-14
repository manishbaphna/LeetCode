import java.util.Arrays;

public class MaxProduct3Nums {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // case1
        int num1 = nums[len-1] * nums[len-2]* nums[len-3];
        int num2 = nums[len-1] * nums[0]* nums[1];
        int num3 = nums[0] * nums[2]* nums[3];

        return Math.max(num1, Math.max(num2, num3));
    }
}
