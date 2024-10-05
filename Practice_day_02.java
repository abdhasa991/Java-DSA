import java.util.ArrayList;  // Importing the ArrayList class from java.util package
import java.util.Arrays;     // Importing the Arrays class for array manipulation

public class Practice_day_02 {

    // Function to check if a number is even
    public static boolean checkOddOrEven(int num) {
        // Return true if num is even, otherwise false
        return num % 2 == 0;
    }

    // Function to calculate the factorial of a number
    public static double getFactorial(double num) {
        double tempNum = 1; // Initialize the variable to hold the factorial value
        // Loop from 1 to num (inclusive) to calculate the factorial
        for (int i = 1; i <= num; i++) {
            tempNum *= i; // Multiply tempNum by the current index
        }
        return tempNum; // Return the calculated factorial
    }

    // Function to check if a number is prime
    public static boolean checkPrimeNumber(int num) {
        int count = 0; // Counter for the number of divisors
        // If num is less than or equal to 1, it is not prime
        if (num <= 1) {
            return false;
        }
        // 2 is a prime number
        if (num == 2) {
            return true;
        }
        // Check divisibility from 3 to num (inclusive)
        for (int i = 3; i <= num; i++) {
            if (num % i == 0) { // If num is divisible by i
                count++; // Increment the divisor count
            }
        }
        // A prime number should have exactly one divisor (itself)
        return count == 1; // Return true if count is 1, false otherwise
    }

    // Function to check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        String numString = Integer.toString(num); // Convert number to string
        StringBuilder reversedString = new StringBuilder(numString); // Create a StringBuilder for reversal
        String mainReversed = reversedString.reverse().toString(); // Reverse the string

        // Return true if the original string is equal to the reversed string
        return numString.equals(mainReversed);
    }

    // Function to generate Fibonacci numbers up to num terms
    public static void getFibonaaciNumbers(int num) {
        int start = 0; // First number in Fibonacci sequence
        int end = 1;   // Second number in Fibonacci sequence
        // Loop to generate Fibonacci numbers up to num terms
        for (int i = 1; i <= num; i++) {
            System.out.print(start + " "); // Print the current Fibonacci number
            int temp = start; // Temporary variable to hold the current start
            start = end;      // Update start to the next number
            end = temp + end; // Update end to the next Fibonacci number
        }
    }

    // Function to check if a number is an Armstrong number
    public static boolean checkArmStrongNumber(int num) {
        // Check if the number is within valid range (0-1000)
        if (num > 1000 || num < 0) {
            return false; // Return false if out of range
        }
        int originalNum = num; // Store the original number for comparison
        int length = String.valueOf(num).length(); // Calculate the number of digits
        int sum = 0; // Initialize sum to hold the Armstrong calculation
        // Loop to calculate the sum of digits raised to the power of the number of digits
        while (num > 0) {
            int digits = num % 10; // Extract the last digit
            sum += Math.pow(digits, length); // Raise to power and add to sum
            num = num / 10; // Remove the last digit
        }
        // Return true if sum equals the original number, false otherwise
        return sum == originalNum;
    }

    // Function to check if a string contains vowels
    public static boolean checkVowels(String chars) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' }; // Array of vowels
        String mainString = chars.toLowerCase(); // Convert input string to lowercase
        boolean hasVowel = false; // Flag to track presence of vowels
        // Loop through each character in the string
        for (int i = 0; i < mainString.length(); i++) {
            char currentChar = mainString.charAt(i); // Get the current character
            // Loop through the array of vowels
            for (char vowel : vowels) {
                // Check if the current character is a vowel
                if (currentChar == vowel) {
                    hasVowel = true; // Set flag to true if a vowel is found
                    break; // Exit the inner loop
                }
            }
        }
        // Return true if any vowel is found, otherwise false
        return hasVowel;
    }

    // Function to find the Greatest Common Divisor (GCD) of two numbers
    public static int getGreatestCommonDivisor(int a, int b) {
        // Get the smaller of the two numbers for efficiency
        int greaterNumber = Math.min(a, b);
        int maxDiv = 1; // Variable to hold the GCD
        // Loop to find GCD by checking each number
        for (int i = 1; i <= greaterNumber; i++) {
            // Check if both numbers are divisible by i
            if (a % i == 0 && b % i == 0) {
                maxDiv = i; // Update maxDiv to the current number
            }
        }
        return maxDiv; // Return the GCD
    }

    // Function to calculate the Least Common Multiple (LCM) of two numbers
    public static int getLCM(int num1, int num2) {
        // LCM is calculated using the relationship with GCD
        return (num1 * num2) / getGreatestCommonDivisor(num1, num2);
    }

    // Function to check if a year is a leap year
    public static boolean checkLeapYear(int num) {
        // A year is a leap year if it is divisible by 4
        return num % 4 == 0;
    }

    // Function to calculate the sum of elements in an array
    public static int sumOfElementsInArray(int[] array) {
        int sum = 0; // Initialize sum to 0
        // Loop through each element in the array
        for (int i = 0; i < array.length; i++) {
            sum += array[i]; // Add the current element to sum
        }
        return sum; // Return the total sum
    }

    // Function to find the second largest element in an ArrayList
    public static int findSecondElementInArray(ArrayList<Integer> array) {
        int max = Integer.MIN_VALUE; // Initialize max to the smallest integer value
        // Loop to find the largest element
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i); // Update max if a larger element is found
            }
        }
        array.remove(Integer.valueOf(max)); // Remove the largest element
        max = Integer.MIN_VALUE; // Reset max to find the second largest
        // Loop again to find the second largest element
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i); // Update max if a larger element is found
            }
        }
        return max; // Return the second largest element
    }

    // Function to find the second largest element in an array
    public static int findSecondElementInArray(int[] array) {
        Arrays.sort(array); // Sort the array in ascending order
        // Return the second largest element (the second last in the sorted array)
        int secondLargestElement = array[array.length - 2];
        return secondLargestElement;
    }

    public static void main(String[] args) {
        int count = 0; // Initialize a counter for even numbers
        int[] array = { 23, 32, 42, 532, 33, 45, 232, 0 }; // Example array of integers

        // Print header for extracting even numbers
        System.out.println("Extracting Even numbers from list: ");
        // Enhanced loop to go through the array
        for (int num : array) {
            // Check if the current number is even
            if (checkOddOrEven(num)) {
                System.out.print(num + " "); // Print the even number
                count++; // Increment the even number counter
            }
        }

        System.out.println(); // Add new line after the list
        // Print total count of even numbers found
        System.out.println("Total Even Numbers in list: " + count);

        // Checking if all numbers in a new array are divisible by 2
        System.out.println("\nChecking if all the numbers in the new list are divisible by 2 or not:");
        int evenCount = 0; // Counter for even numbers in the second array
        int[] array1 = { 2, 4, 6, 8, 10 }; // Second example array

        // Loop through the second array to check for even numbers
        for (int num : array1) {
            if (checkOddOrEven(num)) {
                evenCount++; // Increment the even number counter
            }
        }

        // Output whether all numbers are divisible by 2
        if (evenCount == array1.length) {
            System.out.println("Yes, all numbers are divisible by 2."); // All numbers are even
        } else {
            System.out.println("No, there are also odd numbers."); // There are odd numbers
        }

        // Calculate and print the factorial of a number
        System.out.println("Getting the Factorial of number: ");
        System.out.println("Factorial of that number is: " + (getFactorial(3)));

        // Check if a number is prime and print the result
        if (checkPrimeNumber(49)) {
            System.out.println("Number is Prime.");
        } else {
            System.out.println("Number is not Prime.");
        }

        // Check if a number is a palindrome and print the result
        System.out.println("Checking the number is Palindrome or not: ");
        if (isPalindrome(12321)) {
            System.out.println("Number is Palindrome.");
        } else {
            System.out.println("Number is not Palindrome.");
        }

        // Generate and print Fibonacci numbers
        System.out.println("Printing the Fibonacci terms:  ");
        getFibonaaciNumbers(5); // Print first 5 Fibonacci numbers

        System.out.println();

        // Check if a number is an Armstrong number
        System.out.println("Checking the number is Armstrong or not: ");
        if (checkArmStrongNumber(1200)) {
            System.out.println("Number is Armstrong");
        } else {
            System.out.println("Number is not Armstrong.");
        }

        System.out.println();
        // Check if a string contains vowels
        System.out.println("Checking whether the String Vowel or not: ");
        if (checkVowels("fly")) {
            System.out.println("Yes. This string contains Vowels."); // Vowels found
        } else {
            System.out.println("No. This string doesn't contain any vowel."); // No vowels found
        }

        System.out.println();
        // Find and print the Greatest Common Divisor of two numbers
        System.out.println("Finding Greatest Common Divisor: ");
        System.out.println("Greatest Common Divisor " + getGreatestCommonDivisor(8, 12));

        // Find and print the Least Common Multiple of two numbers
        System.out.println("Printing the LCM of two numbers: ");
        System.out.println(getLCM(12, 18));

        // Check if a year is a leap year
        System.out.println("Checking the Year is Leap or Not: ");
        if (checkLeapYear(2001)) {
            System.out.println("This is Leap Year."); // Leap year found
        } else {
            System.out.println("This is not a Leap year."); // Not a leap year
        }

        // Calculate and print the sum of elements in an array
        System.out.println("Printing the sum of elements in an array : ");
        int[] arr = {5, 1, 4, 7, 9}; // Example array
        System.out.print("Sum = " + sumOfElementsInArray(arr)); // Print the sum

        // Find and print the second largest element in an ArrayList
        System.out.println("Finding second element in an array: ");
        ArrayList<Integer> arr1 = new ArrayList<Integer>(); // Create an ArrayList
        arr1.add(10); // Add elements to the ArrayList
        arr1.add(30);
        arr1.add(50);
        arr1.add(20);
        arr1.add(40);
        System.out.println("Second Largest Element in an array is: " + findSecondElementInArray(arr1));

        System.out.println();
        // Find and print the second largest element in an array using Arrays library
        System.out.println("Printing Second Largest element of an array using simple Arrays Library.");
        System.out.println("Second Largest element in an array is " + findSecondElementInArray(arr));
    }
}
