import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitsOnATruck {

    // Faster way to avoid costly sorting
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] buckets = new int[1001];
        int units = 0;

        for ( int[] arr: boxTypes) {
            buckets[arr[1]] += arr[0];

        }

        for (int i = buckets.length -1 ; i>=0; --i) {
            if ( buckets[i] == 0)
                continue;

            units +=  Math.min(truckSize, buckets[i]) * i;
            truckSize -= Math.min(truckSize, buckets[i]);

            if (truckSize == 0)
                break;

        }

        return units;
    }

    // Intuitive way, Reverse sort 2D array on number of Units
    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (arr1, arr2) -> Integer.compare(arr2[1], arr1[1]));

        int units = 0;
        for (int i=0; i<boxTypes.length;++i){

            System.out.println("truckSize:" + truckSize);
            units +=  Math.min(truckSize, boxTypes[i][0]) * boxTypes[i][1];
            truckSize -= Math.min(truckSize, boxTypes[i][0]);

            if (truckSize == 0)
                break;
        }

        return units;
    }
}
