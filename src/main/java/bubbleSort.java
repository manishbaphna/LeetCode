import java.util.Arrays;

public class bubbleSort {
    private void swap(int arr[], int i, int j) {
        int backup = arr[i];
        arr[i] = arr[j];
        arr[j] = backup;
    }

    void impl(int arr[], int begin, int end){
        if (begin == end) {
            return;
        }
        int idx = end;

        for (int i=begin; i <=end; ++i) {
            if (arr[i] < arr[end]) {
                swap(arr, i, end);
            }
        }

        impl(arr, begin, --end);
    }

    // int[] is pass by reference so no need to return
    void bubbleSort(int arr[]) {
        impl(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        bubbleSort bs = new bubbleSort();
        int [] arr = new int[]{11, 2, 32, 4, 5, 46, 7, 28, 19, 10};
        bs.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
