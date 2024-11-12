import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class DSA {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public static void main(String[] args) {
        DSA dsa = new DSA();
        dsa.generateKeyPair();

        Scanner sc = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nChoose an option: ");
            System.out.println("1. Sign a message");
            System.out.println("2. Verify a signature");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter message to sign:");
                    String messageToSign = sc.nextLine();
                    String signature = dsa.signMessage(messageToSign);
                    System.out.println("Signature: " + signature);
                    break;
                case 2:
                    System.out.println("Enter message to verify:");
                    String messageToVerify = sc.nextLine();
                    System.out.println("Enter signature to verify:");
                    String signatureToVerify = sc.nextLine();
                    boolean isVerified = dsa.verifySignature(messageToVerify, signatureToVerify);
                    System.out.println("Signature verified: " + isVerified);
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
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String signMessage(String message) {
        try {
            Signature signature = Signature.getInstance("SHA256withDSA");
            signature.initSign(privateKey);
            signature.update(message.getBytes());
            byte[] signedMessage = signature.sign();
            return Base64.getEncoder().encodeToString(signedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verifySignature(String message, String signatureToVerify) {
        try {
            Signature signature = Signature.getInstance("SHA256withDSA");
            signature.initVerify(publicKey);
            signature.update(message.getBytes());
            byte[] decodedSignature = Base64.getDecoder().decode(signatureToVerify);
            return signature.verify(decodedSignature);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
