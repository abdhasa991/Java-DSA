import java.util.ArrayList;
import java.util.Scanner;

public class HillCipher {

    public static void main(String[] args) {
        ArrayList<Character> plainTextArray = new ArrayList<>();
        ArrayList<Integer> indexesOfKey = new ArrayList<>();
        ArrayList<Integer> indexOfPlainText = new ArrayList<>();
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] K = {'h', 'i', 'l', 'l'};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to encrypt: ");
        String plainText = scanner.nextLine().toLowerCase();
        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                plainTextArray.add(c);
            }
        }
        for (char k : K) {
            for (int j = 0; j < charArray.length; j++) {
                if (k == charArray[j]) {
                    indexesOfKey.add(j);
                }
            }
        }
        for (char p : plainTextArray) {
            for (int j = 0; j < charArray.length; j++) {
                if (p == charArray[j]) {
                    indexOfPlainText.add(j);
                }
            }
        }
        ArrayList<Character> encryptedArray = new ArrayList<>();
        for (int i = 0; i < indexOfPlainText.size(); i += 2) { 
            if (i + 1 < indexOfPlainText.size()) { 
                int c1 = (indexesOfKey.get(0) * indexOfPlainText.get(i)) + (indexesOfKey.get(1) * indexOfPlainText.get(i + 1));
                int c2 = (indexesOfKey.get(2) * indexOfPlainText.get(i)) + (indexesOfKey.get(3) * indexOfPlainText.get(i + 1));
                int rem1 = c1 % 26;
                int rem2 = c2 % 26;
                encryptedArray.add(charArray[rem1]);
                encryptedArray.add(charArray[rem2]);
            } else {
                int c1 = indexesOfKey.get(0) * indexOfPlainText.get(i); 
                int rem1 = c1 % 26;
                encryptedArray.add(charArray[rem1]);
            }
        }
        StringBuilder encryptedText = new StringBuilder();
        for (char ch : encryptedArray) {
            encryptedText.append(ch);
        }
        System.out.println("Encrypted text: " + encryptedText.toString().toUpperCase());
        scanner.close();
    }
}
