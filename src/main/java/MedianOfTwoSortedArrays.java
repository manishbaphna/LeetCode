import java.awt.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        boolean oneMedian = ((nums1.length + nums2.length ) & 0x1) == 0;
        int desiredCount = 1 + (nums1.length + nums2.length ) / 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        while ( p1 < nums1.length && p2 < nums2.length) {
            pq.add(Math.min(nums1[p1], nums2[p2]));

            if ( pq.size() == desiredCount + 1)
                break;
        }

        int[] leftOver = ( p1 == nums1.length ) ? nums2 : nums1;
        int count = ( p1 == nums1.length ) ? p2 : p1;
        while (pq.size() < desiredCount + 1) {
            pq.add(leftOver[count++]);
        }

        if (oneMedian)
            return pq.peek();
        else {
            int lastVal = pq.poll();
            return (double) (lastVal + pq.peek()) / 2;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(4);
        pq.offer(3);
        pq.offer(8);

        System.out.println(pq.peek());


    }
}
