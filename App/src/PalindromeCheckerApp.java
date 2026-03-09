import java.util.Scanner;
import java.util.Stack;

// 1. PalindromeChecker Class (Removed 'public' so it can sit in this file)
class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        // Normalize string (ignore case and non-alphanumeric characters)
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Internal Data Structure: Stack
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        // Pop characters off the stack and compare.
        // Because a Stack is Last-In-First-Out (LIFO), popping gives us the reversed string.
        for (char c : cleanInput.toCharArray()) {
            if (stack.pop() != c) {
                return false; // Mismatch found
            }
        }

        return true;
    }
}

// 2. Main Application Class (Must be public and match the filename)
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate our dedicated service object
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        // Delegate the actual checking to the service
        boolean result = checker.checkPalindrome(userInput);

        if (result) {
            System.out.println("Result: '" + userInput + "' IS a palindrome.");
        } else {
            System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}