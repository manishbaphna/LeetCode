import java.util.Arrays;

// find kth element in a set of dataa
public class KthElement {

    static private void swap(int arr[], int i, int j) {
        int backup = arr[i];
        arr[i] = arr[j];
        arr[j] = backup;
    }

    static int impl(int arr[], int begin, int end, int k){
        if ( begin == end )
            return arr[begin];

        int pivot = arr[end];

        int partionIndex = begin - 1;

        for (int i = begin; i < end; ++i) {
            if ( arr[i] < pivot ) {
                ++partionIndex;

                if ( i != partionIndex )
                    swap(arr, i, partionIndex);
            }
        }

        swap(arr, partionIndex+1, end);

        if ( k == partionIndex+1 )
            return partionIndex+1;

        if ( k < partionIndex+1 )
            return impl(arr, begin, partionIndex, k);

        return impl(arr, partionIndex+2, end, k);
    }

    int getKthElement(int arr[], int k) {
        return impl(arr, 0, arr.length-1, k);
    }



    public static void main(String[] args) {
        int arr[] = new int[]{4,6,0,1,3,2,5};
        KthElement kthElement = new KthElement();
        for (int i=0; i <arr.length;++i)
            System.out.println("i=" +i + " ith=" + kthElement.getKthElement(new int[]{4,6,0,1,3,2,5}, i));

    }
}
