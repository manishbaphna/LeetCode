import java.util.Arrays;

// find kth element in a set of dataa
public class qsort {

    static private void swap(int arr[], int i, int j) {
        int backup = arr[i];
        arr[i] = arr[j];
        arr[j] = backup;
    }

    static int impl(int arr[], int begin, int end, int k){
        if ( begin >= end )
            return -1;

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
        return partionIndex+1;
    }

    int getKthElement(int arr[], int k) {
        return impl(arr, 0, arr.length-1, k);
    }

    static void qsort(int[] arr) {
        int partionIndex = impl(arr, 0, arr.length-1, -1);

        impl(arr, 0, partionIndex -1 , -1);
        impl(arr, partionIndex +1 , arr.length -1 , -1);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,6,0,1,3,2,5};
        qsort(arr);
        System.out.println(Arrays.toString(arr));

        /*int arr[] = new int[]{4,6,0,1,3,2,5};
        KthElement kthElement = new KthElement();
        for (int i=0; i <arr.length;++i)
            System.out.println("i=" +i + " ith=" + kthElement.getKthElement(new int[]{4,6,0,1,3,2,5}, i));*/

    }
}
