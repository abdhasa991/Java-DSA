import java.util.Arrays;

public class Merge_Sort {

    public static void mergeSort(char[] arr, int start, int end) {
        if (start >= end) {
            return; 
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        for (int i = mid + 1; i <= end; i++) {
            for (int j = i; j > start && arr[j] < arr[j - 1]; j--) {
                char temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String name = "Muhammad Abdullah".replaceAll("\\s", "").toLowerCase();
        char[] nameChars = name.toCharArray();
        mergeSort(nameChars, 0, nameChars.length - 1); 
        System.out.println("Roll #: 23-CBS-13");
        System.out.println(Arrays.toString(nameChars)); 
    }
}
