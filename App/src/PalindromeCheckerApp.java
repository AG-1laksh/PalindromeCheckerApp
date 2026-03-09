import java.util.Scanner;
import java.util.Deque;      // ADDED: This import is required to use the Deque interface
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Method to check String Palindrome using a Deque
    private static boolean checkPalindrome(String str, int start, int end) {
        // Base Condition 1: If pointers cross or meet, all characters matched
        if (start >= end) {
            return true;
        }

        // Base Condition 2: Mismatch found, terminate early
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call: move start forward and end backward
        return checkPalindrome(str, start + 1, end - 1);
    }

    // Wrapper method to clean the input and trigger the recursion
    public static boolean isPalindrome(String input) {
        // Clean the input string (remove spaces/punctuation and make lowercase)
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Handle edge case of an empty string
        if (cleanInput.isEmpty()) {
            return true;
        }

        // Initiate the recursion starting at the first and last indices
        return checkPalindrome(cleanInput, 0, cleanInput.length() - 1);
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