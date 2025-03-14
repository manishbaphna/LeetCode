

public class RemoveDupes {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1)
            return nums.length;

        int p1 = 0;
        int p2 = 1;

        for (; p2 < nums.length ; ++p2) {
            if ( nums[p1] != nums[p2]) {
                nums[++p1] = nums[p2];
            }
        }

        for (int k=0; k <1+p1; ++k)
            System.out.println(nums[k]);
        return p1+1;
    }

    public static void main(String[] args) {
        RemoveDupes dut = new RemoveDupes();
        int ans = dut.removeDuplicates(new int[]{1,1,2});
        //System.out.println(ans);
    }
}
