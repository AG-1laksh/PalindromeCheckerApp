import java.util.Scanner;
import java.util.Deque;      // ADDED: This import is required to use the Deque interface
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {
        // Handle null input safely
        if (input == null) {
            return false;
        }

        // 1. String Preprocessing & Regular Expressions
        // Replace everything that is NOT a letter or number with an empty string,
        // then convert the entire result to lowercase.
        String normalizedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. Apply Palindrome Logic (Using String/Array indexing)
        int left = 0;
        int right = normalizedInput.length() - 1;

        // Compare characters from the outside in
        while (left < right) {
            if (normalizedInput.charAt(left) != normalizedInput.charAt(right)) {
                return false; // Mismatch found
            }
            left++;
            right--;
        }

        // If the loop finishes without returning false, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check (try adding spaces and mixed cases!): ");
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