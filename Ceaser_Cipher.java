import java.util.Scanner;

public class Ceaser_Cipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------Created By Master X----------------");
        System.out.println("Name: Muhammad Abdullah" + 
        "\nRoll #: 23-CBS-13\nDepartment: Cyber Security Batch 2023\n");

        System.out.println("Please choose one of the following by typing numbers: ");
        System.out.println("1. Encryption           2. Decryption");
        System.out.println("              3. Exit");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.println("Enter Plain Text to encrypt:");
            String string = sc.nextLine().toLowerCase();
            System.out.println("Converting plain text into Cipher Text....");
            try {
                Thread.sleep(2000);
                for (int i = 0; i < string.length(); i++) {
                    char ch = string.charAt(i);
                    if (ch == ' ') {
                        System.out.print(' '); // Preserve spaces
                    } else {
                        int targetIndex = (ch - 'a' + 3) % 26; // Shift 3 positions
                        System.out.print((char) (targetIndex + 'a'));
                    }
                }
                System.out.println(); // New line after encryption
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            System.out.println("\nEnter Cipher Text to decrypt: ");
            String input2 = sc.nextLine().toLowerCase();
            System.out.println("Converting Cipher Text into Plain Text....");
            try {
                Thread.sleep(2000);
                for (int i = 0; i < input2.length(); i++) {
                    char ch = input2.charAt(i);
                    if (ch == ' ') {
                        System.out.print(' '); // Preserve spaces
                    } else {
                        int targetIndex1 = (ch - 'a' - 3 + 26) % 26; // Shift back 3 positions
                        System.out.print((char) (targetIndex1 + 'a'));
                    }
                }
                System.out.println(); // New line after decryption
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (choice == 3) {
            try {
                System.out.println("Thanks for using! Quitting the program....");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong number! Please enter a valid number.");
        }

        sc.close();
    }
}
