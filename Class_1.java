import java.util.*;

public class Class_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array1 = { 1, 2, 3, 4, 5 };
        int[] array2 = new int[5];
        System.out.println("Printing using For loop: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Enter value at index " + i);
            int num = sc.nextInt();
            array2[i] += num;
        }
        System.out.println("Printing by asking inputs ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        sc.close();
    }
}