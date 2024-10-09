import java.util.Scanner;

public class Ceaser_Cipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------Created By Master X----------------");
        System.out.println("Name: Muhamamd Abdullah" + 
        "\nRoll #: 23-CBS-13\nDepartment: Cyber Security Batch 2023\n");
        char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z' };

        System.out.println("Please choose anyone of the following by typing numbers: ");
        System.out.println("1. Encryption           2. Decryption");
        System.out.println("              3. Exit");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter Plain Text to encrypt");
            String string = sc.next().toLowerCase();
            System.out.println("Converting plain text into Cipher Text....");
            try {
                Thread.sleep(2000);
                for (int i = 0; i < string.length(); i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (string.charAt(i) == arr[j]) {
                            int target_index = j + 3;
                            if (target_index < 26) {
                                System.out.print(arr[target_index]);
                            } else {
                                int finalTarget_index = target_index % 26;
                                System.out.print(arr[finalTarget_index]);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sc.nextLine();
        } else if (choice == 2) {
            System.out.println("\nEnter Cipher Text to decrypt: ");
            String input2 = sc.next();

            sc.nextLine();
            System.out.println("Converting Cipher Text into Plain Text....");
            try {
                Thread.sleep(2000);
                for (int i = 0; i < input2.length(); i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (input2.charAt(i) == arr[j]) {
                            int target_index1 = j - 3;
                            if (target_index1 >= 0 && target_index1 <= 22) {
                                System.out.print(arr[target_index1]);
                            } else {
                                int finalTarget_index1 = 26 + target_index1;
                                System.out.print(arr[finalTarget_index1]);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (choice == 3) {
            try {
                System.out.println("Thanks for using!. Quiting the program....");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong number! please enter valid number.");
        }

        sc.close();
    }
}