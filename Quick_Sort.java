import java.util.Arrays;

public class Quick_Sort {

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return; 
        }
        int pivot = arr[end];
        int partitionIndex = start; 

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[partitionIndex];
                arr[partitionIndex] = temp;

                partitionIndex++; 
            }
        }

        int temp = arr[partitionIndex];
        arr[partitionIndex] = arr[end];
        arr[end] = temp;

        quickSort(arr, start, partitionIndex - 1); 
        quickSort(arr, partitionIndex + 1, end);  
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 0, 3, 5, 0, 1};
        quickSort(array, 0, array.length - 1); 
        System.out.println("Name: Muhammad Abdullah");
        System.out.println(Arrays.toString(array)); 
    }
}
