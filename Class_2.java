import java.util.*; // Importing the entire java.util package for utility classes like Scanner

public class Class_2 {

    // Method to calculate the sum of two integers
    public static int printSum(int num1, int num2) {
        return num1 + num2; // Returns the sum of num1 and num2
    }

    // Method to print a given name
    public static void printName(String Name){
        System.out.println("Name: " + Name); // Prints the name with a prefix "Name: "
    }

    // Method to calculate the sum of the first 'num' natural numbers
    // Formula used: num * (num + 1) / 2
    public static int natNumSum(int num){
        return num * (num + 1) / 2; // Returns the sum of the first 'num' natural numbers
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
        char[] char_array = {'a', 'b', 'c'};
        for (int i = 0; i < char_array.length; i++){
            System.out.println(char_array[i] + " "); // Prints each character followed by a space
        }

        // Calling the printName method with "Abdullah" as the argument
        printName("Abdullah"); // Prints "Name: Abdullah"

        // Asking the user for input on how many natural numbers' sum to calculate
        System.out.println("Enter how much natural numbers sum you want to print: ");
        int num = sc.nextInt(); // Reads the integer input from the user

        // Calling natNumSum method and printing the sum of first 'num' natural numbers
        System.out.println("Sum of first " + num + " natural numbers: " + natNumSum(num));

        sc.close(); // Closing the scanner to prevent resource leaks
    }
}
