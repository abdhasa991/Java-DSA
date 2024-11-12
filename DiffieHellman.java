import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class DiffieHellman {

    private BigInteger privateKeyA;
    private BigInteger privateKeyB;
    private BigInteger publicKeyA;
    private BigInteger publicKeyB;
    private BigInteger sharedSecretA;
    private BigInteger sharedSecretB;

    public static void main(String[] args) {
        DiffieHellman dh = new DiffieHellman();
        dh.initialize();

        Scanner sc = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nChoose an option: ");
            System.out.println("1. Generate keys");
            System.out.println("2. Exchange keys and generate shared secret");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dh.generateKeys();
                    System.out.println("Keys generated.");
                    break;
                case 2:
                    dh.exchangeKeys();
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

    public void initialize() {
        privateKeyA = BigInteger.ZERO;
        privateKeyB = BigInteger.ZERO;
        publicKeyA = BigInteger.ZERO;
        publicKeyB = BigInteger.ZERO;
        sharedSecretA = BigInteger.ZERO;
        sharedSecretB = BigInteger.ZERO;
    }

    public void generateKeys() {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(512, random); 
        BigInteger g = BigInteger.valueOf(2); 

        privateKeyA = new BigInteger(512, random); 
        publicKeyA = g.modPow(privateKeyA, p); 

        privateKeyB = new BigInteger(512, random); 
        publicKeyB = g.modPow(privateKeyB, p);

        System.out.println("Public Key A: " + publicKeyA);
        System.out.println("Public Key B: " + publicKeyB);
    }

    public void exchangeKeys() {
        BigInteger p = BigInteger.probablePrime(512, new SecureRandom()); 
        // BigInteger g = BigInteger.valueOf(2); 

        sharedSecretA = publicKeyB.modPow(privateKeyA, p); 
        sharedSecretB = publicKeyA.modPow(privateKeyB, p); 

        System.out.println("Shared Secret A: " + sharedSecretA);
        System.out.println("Shared Secret B: " + sharedSecretB);
    }
}
