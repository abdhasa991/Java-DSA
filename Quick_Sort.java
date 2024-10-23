import java.util.Arrays;

public class Quick_Sort {

    // Method to perform QuickSort on an integer array
    static void quickSort(int[] arr, int start, int end) {
        // Base case: if start index is greater than or equal to end, return
        if (start >= end) {
            return; 
        }

        // Select the last element as the pivot
        int pivot = arr[end];

        // Index to partition the array into elements less than and greater than the pivot
        int partitionIndex = start; 

        // Loop through the array from start to end - 1
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot, swap it with the element at partitionIndex
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[partitionIndex];
                arr[partitionIndex] = temp;

                // Move partitionIndex to the right
                partitionIndex++; 
            }
        }

        // Place the pivot in its correct sorted position by swapping with partitionIndex
        int temp = arr[partitionIndex];
        arr[partitionIndex] = arr[end];
        arr[end] = temp;

        // Recursively sort the subarrays to the left and right of the pivot
        quickSort(arr, start, partitionIndex - 1); // Left subarray
        quickSort(arr, partitionIndex + 1, end);   // Right subarray
    }

    public static void main(String[] args) {
        // Array to be sorted using QuickSort
        int[] array = {4, 2, 0, 3, 5, 0, 1};
        
        // Sorting the array
        quickSort(array, 0, array.length - 1); 
        
        // Printing name and sorted array
        System.out.println("Name: Muhammad Abdullah");
        System.out.println(Arrays.toString(array)); // Output the sorted array
    }
}
