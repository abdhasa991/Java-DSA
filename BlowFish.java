import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class BlowFish {

    private static final String KEY = "abcdefgh"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option: 1. Encrypt  2. Decrypt  3. Exit");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice == 1) {
            System.out.println("Enter Plain Text to Encrypt (alphanumeric and special characters):");
            String plaintext = sc.nextLine(); 
            String encryptedText = encrypt(plaintext); 
            System.out.println("Encrypted Text (Base64): " + encryptedText);
        } else if (choice == 2) {
            System.out.println("Enter Cipher Text to Decrypt (Base64 only):");
            String ciphertext = sc.nextLine(); 
            String decryptedText = decrypt(ciphertext); 
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Exiting program."); 
        }

        sc.close(); 
    }

    public static String encrypt(String plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String ciphertext) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(ciphertext); 
            Cipher cipher = Cipher.getInstance("Blowfish");
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
