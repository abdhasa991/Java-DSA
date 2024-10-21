import java.util.Arrays;

public class Merge_Sort {

    static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return; 
        }
        int mid = (start + end) / 2; 
        mergeSort(arr, start, mid); 
        mergeSort(arr, mid + 1, end); 

        for (int i = mid + 1; i <= end; i++) {
            for (int j = i; j > start && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = { 4, 2, 0, 3, 5, 0, 1, 0, 2, 3, 10, 9};
        mergeSort(array, 0, array.length - 1); 
        System.out.println(Arrays.toString(array)); 
    }
}
