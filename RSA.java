import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;

public class RSA {

    private static final int KEY_SIZE = 2048;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(KEY_SIZE, new SecureRandom());
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        while (true) {
            System.out.println("Choose an option: 1. Encrypt  2. Decrypt  3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter Plain Text to Encrypt:");
                String plaintext = sc.nextLine();
                String encryptedText = encrypt(plaintext, publicKey);
                System.out.println("Encrypted Text (Base64): " + encryptedText);

                // Immediately ask for decryption of the same encrypted text
                System.out.println("Enter the Cipher Text to Decrypt:");
                String decryptedText = decrypt(encryptedText, privateKey);
                System.out.println("Decrypted Text: " + decryptedText);
            } else if (choice == 2) {
                System.out.println("Enter Cipher Text to Decrypt (Base64 only):");
                String ciphertext = sc.nextLine();
                String decryptedText = decrypt(ciphertext, privateKey);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Exiting program.");
                break;
            }
        }

        sc.close();
    }

    public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String ciphertext, PrivateKey privateKey) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}
