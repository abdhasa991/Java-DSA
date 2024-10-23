import java.util.Scanner;

public class SimplePlayfairCipher {
    private static char[][] table = new char[5][5]; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter key: ");
        String key = input.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        System.out.print("Enter message: ");
        String message = input.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        createTable(key);
        System.out.println("Encrypted: " + encryptMessage(message));
    }
    private static void createTable(String key) {
        String alphabet = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ"; 
        boolean[] usedLetters = new boolean[26];
        int count = 0;

        for (char letter : alphabet.toCharArray()) {
            if (!usedLetters[letter - 'A']) {
                table[count / 5][count % 5] = letter;
                usedLetters[letter - 'A'] = true;
                count++;
            }
        }
    }
    private static String encryptMessage(String message) {
        StringBuilder result = new StringBuilder();
        message = prepareMessage(message);

        for (int i = 0; i < message.length(); i += 2) {
            int[] pos1 = findPosition(message.charAt(i));
            int[] pos2 = findPosition(message.charAt(i + 1));

            if (pos1[0] == pos2[0]) {
                result.append(table[pos1[0]][(pos1[1] + 1) % 5]);
                result.append(table[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) { 
                result.append(table[(pos1[0] + 1) % 5][pos1[1]]);
                result.append(table[(pos2[0] + 1) % 5][pos2[1]]);
            } else { 
                result.append(table[pos1[0]][pos2[1]]);
                result.append(table[pos2[0]][pos1[1]]);
            }
        }
        return result.toString();
    }

    private static String prepareMessage(String message) {
        StringBuilder prepared = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            prepared.append(message.charAt(i));
            if (i + 1 < message.length() && message.charAt(i) == message.charAt(i + 1)) {
                prepared.append('X');
            }
        }

        if (prepared.length() % 2 != 0) {
            prepared.append('X');
        }

        return prepared.toString();
    }

    private static int[] findPosition(char letter) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (table[row][col] == letter) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }
}
