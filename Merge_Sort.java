import java.util.Arrays;

public class Merge_Sort {

    // Method to perform merge sort on a character array
    public static void mergeSort(char[] arr, int start, int end) {
        // Base case: if the start index is greater than or equal to the end, return
        if (start >= end) {
            return; 
        }

        // Find the middle point of the current section of the array
        int mid = (start + end) / 2;

        // Recursively sort the first half (from start to mid)
        mergeSort(arr, start, mid);

        // Recursively sort the second half (from mid+1 to end)
        mergeSort(arr, mid + 1, end);

        // Merging the two halves by sorting them directly without using extra space
        for (int i = mid + 1; i <= end; i++) {
            for (int j = i; j > start && arr[j] < arr[j - 1]; j--) {
                // Swap adjacent elements if they are in the wrong order
                char temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Removing spaces and converting the name to lowercase
        String name = "Muhammad Abdullah".replaceAll("\\s", "").toLowerCase();
        
        // Converting the string to a character array
        char[] nameChars = name.toCharArray();
        
        // Sorting the character array using mergeSort
        mergeSort(nameChars, 0, nameChars.length - 1); 
        
        // Printing roll number and sorted characters of the name
        System.out.println("Roll #: 23-CBS-13");
        System.out.println(Arrays.toString(nameChars)); // Output the sorted characters
    }
}
