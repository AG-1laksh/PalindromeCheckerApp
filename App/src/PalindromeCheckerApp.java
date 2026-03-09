import java.util.Scanner;
import java.util.Deque;      // ADDED: This import is required to use the Deque interface
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Method to check String Palindrome using a Deque
    public static boolean isPalindrome(String input) {
        // Optional: Clean the input string (remove spaces/punctuation and make lowercase)
        // This ensures phrases like "Race car" are correctly identified.
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 1. Initialize the Deque
        Deque<Character> deque = new ArrayDeque<>();

        // 2. Insert characters into the deque
        for (char c : cleanInput.toCharArray()) {
            deque.addLast(c);
        }

        // 3. Remove first & last and compare until empty (or 1 character remains)
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            // If a mismatch is found, it's not a palindrome
            if (first != last) {
                return false;
            }
        }

        // If loop completes without mismatches, it is a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        boolean result = isPalindrome(userInput);

        if (result) {
            System.out.println("Result: '" + userInput + "' IS a palindrome.");
        } else {
            System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}