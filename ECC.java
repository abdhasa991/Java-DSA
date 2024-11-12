//javac -cp ".;bcprov-jdk15on-1.70.jar" ECC.java   
// javac -cp ".;bcprov-jdk15on-1.70.jar" ECC.java
// Command to Run Code.
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;

public class ECC {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public static void main(String[] args) {
        ECC ecc = new ECC();
        ecc.generateKeyPair();

        Scanner sc = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nChoose an option: ");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter message to encrypt:");
                    String message = sc.nextLine();
                    String encryptedText = ecc.encrypt(message);
                    System.out.println("Encrypted Message: " + encryptedText);
                    break;
                case 2:
                    System.out.println("Enter encrypted message to decrypt:");
                    String encryptedMessage = sc.nextLine();
                    String decryptedText = ecc.decrypt(encryptedMessage);
                    System.out.println("Decrypted Message: " + decryptedText);
                    break;
                case 3:
                    continueRunning = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        sc.close();
        System.out.println("Exiting the program.");
    }

    public void generateKeyPair() {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("EC");
            keyPairGen.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPair = keyPairGen.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String message) {
        try {
            Cipher cipher = Cipher.getInstance("ECIES");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedMessage = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("ECIES");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}



