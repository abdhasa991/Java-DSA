import java.util.Scanner;  // Importing the Scanner class from the java.util package for input handling.

public class Class_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Creating a Scanner object to read input from the user.

        // Initializing an array 'array1' with predefined values.
        int[] array1 = { 1, 2, 3, 4, 5 };

        // Initializing another array 'array2' with a fixed size of 5 elements, initially filled with 0.
        int[] array2 = new int[5];

        // Printing elements of 'array1' using a for loop.
        System.out.println("Printing using For loop: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");  // Display each element of 'array1'.
        }
        System.out.println();  // Move to the next line after printing the elements.

        // Prompting the user to input values into 'array2'.
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Enter value at index " + i);  // Ask the user for a value at each index.
            int num = sc.nextInt();  // Read the integer input.
            array2[i] += num;  // Store the input value at the corresponding index in 'array2'.
        }

        // Printing the elements of 'array2' after taking user inputs.
        System.out.println("Printing by asking inputs ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");  // Display each element of 'array2' entered by the user.
        }

        sc.close();  // Close the Scanner to avoid resource leaks.
    }
}
