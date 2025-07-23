// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class PosOfFirstAndLast {


    public int[] impl(int[] nums, int start, int end, int target) {
        if ( start > end )
            return new int[]{-1, -1};

        int mid = (start + end) / 2;

        if ( nums[mid] == target) {
            int left = mid;
            while ( left > 0 && nums[left-1] == target)
                left = left - 1;

            int right = mid;
            while ( right < nums.length -1 && nums[right+1] == target)
                right += 1;

            return new int[]{left, right};

        } else if ( nums[mid] < target) {
            return impl(nums, mid+1, end, target);
        } else {
            return impl(nums, start, mid-1, target);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if ( nums == null)
            return new int[]{-1, -1};

        return impl(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args) {
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(result[0] + " " + result[1]);
    }
}
