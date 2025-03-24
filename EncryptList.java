
import java.util.LinkedList;
import java.util.Scanner;

public class EncryptList {
    
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char encryptedChar = (char) (base + (ch - base + key) % 26);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> encryptedWords = new LinkedList<>();     // LinkedList to store encrypted words
        System.out.println("Enter the encryption key (integer): ");
        int key = scanner.nextInt();
        scanner.nextLine();
        boolean continueEncrypting = true;
        while (continueEncrypting) {
            System.out.println("Enter word(s) to be encrypted: ");
            String word = scanner.nextLine();
            String encryptedWord = encrypt(word, key);
            encryptedWords.add(encryptedWord);      // Adds the encrypted word(s) to the LinkedList.
            System.out.println("Do you have more words to encrypt? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                continueEncrypting = false;
            }
        }       
        System.out.println("\nEncrypted Words: ");
        for (String encryptedWord : encryptedWords) {       // Iterate through the LinkedList
            System.out.println(encryptedWord);      // Print each encrypted word
        }
        scanner.close();
    }
}
