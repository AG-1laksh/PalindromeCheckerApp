import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        // Initialize the Stack
        Stack<Character> stack = new Stack<>();

        // 1. Push characters into stack
        // Iterating through the string and pushing each character
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // 2. Pop and compare
        // The stack pops elements in reverse order (LIFO)
        for (int i = 0; i < str.length(); i++) {
            char poppedChar = stack.pop();

            // Compare the original character with the popped (reversed) character
            if (str.charAt(i) != poppedChar) {
                return false; // If there's a mismatch, it's not a palindrome
            }
        }

        return true; // If we finish the loop with no mismatches, it is a palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // 3. Print result
        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' IS a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

}
    // Method to check String Palindrome




