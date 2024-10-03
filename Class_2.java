import java.util.*; // Importing the entire java.util package for utility classes like Scanner

public class Class_2 {

    // Method to calculate the sum of two integers
    public static int printSum(int num1, int num2) {
        return num1 + num2; // Returns the sum of num1 and num2
    }

    // Method to print a given name
    public static void printName(String name) { // Changed 'Name' to 'name' to follow camelCase convention
        System.out.println("Name: " + name); // Prints the name with a prefix "Name: "
    }

    // Method to calculate the sum of the first 'num' natural numbers
    // Formula used: num * (num + 1) / 2
    public static int natNumSum(int num) {
        if (num < 0) { // Added validation for negative numbers
            System.out.println("Please enter a positive number.");
            return 0;
        }
        return num * (num + 1) / 2; // Returns the sum of the first 'num' natural numbers
    }

    // Function to check whether the number is Even OR Odd.
    public static void getOddOrEven(int num) {
        if (num % 2 == 0) {
            System.out.println("This is an Even Number.");
        } else {
            System.out.println("This is an Odd Number.");
        }
    }

    // Method to find the maximum element in an array
    public static int getMaxElementInArray(int[] num) {
        int max_element = Integer.MIN_VALUE; // Initialize to the minimum possible value
        for (int i = 0; i < num.length; i++) {
            if (max_element < num[i]) {
                max_element = num[i];
            }
        }
        return max_element; // Returns the maximum element found in the array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creating a scanner object for user input

        // Initializing and printing elements of a string array
        String[] array = { "Tahir", "Abdullah" };
        System.out.println(array[0]); // Prints the first element, "Tahir"
        System.out.println(array[1]); // Prints the second element, "Abdullah"

        // Calling printSum method to calculate the sum of 5 and 10, then printing the result
        System.out.println("Sum = " + printSum(5, 10)); // Prints "Sum = 15"

        // Creating a character array and printing each character in the array
        char[] charArray = {'a', 'b', 'c'}; // Changed 'char_array' to 'charArray' to follow camelCase
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " "); // Prints each character followed by a space
        }
        System.out.println(); // To move to the next line after printing the array

        // Calling the printName method with "Abdullah" as the argument
        printName("Abdullah"); // Prints "Name: Abdullah"

        // Asking the user for input on how many natural numbers' sum to calculate
        System.out.println("Enter how many natural numbers' sum you want to print: ");
        int num = sc.nextInt(); // Reads the integer input from the user

        // Calling natNumSum method and printing the sum of first 'num' natural numbers
        System.out.println("Sum of first " + num + " natural numbers: " + natNumSum(num));

        // Calling getOddOrEven method to check whether the number is even or odd
        System.out.println("Enter the number you want to check whether it is Even or Odd: ");
        int Num = sc.nextInt(); // Changed 'Num' to 'num' for consistency with naming convention
        getOddOrEven(Num);

        // Creating an array and printing the maximum element
        int[] arr = {10, 20, 40, 30, 50};
        System.out.println("Max element in array is: " + getMaxElementInArray(arr)); // Calling the Method to get Max element in array.

        sc.close(); // Closing the scanner to prevent resource leaks
    }
}
