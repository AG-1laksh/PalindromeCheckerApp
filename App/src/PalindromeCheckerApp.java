import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// 1. Define PalindromeStrategy interface
// This acts as a contract. Any class implementing this MUST have a check() method.
interface PalindromeStrategy {
    boolean check(String input);
}

// 2a. Implement StackStrategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }
        for (char c : cleanInput.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }
}

// 2b. Implement DequeStrategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleanInput.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Main Application Class
public class PalindromeCheckerApp {

    // 3. Inject strategy at runtime
    // This method takes ANY valid strategy via Polymorphism
    public static boolean executeStrategy(String input, PalindromeStrategy strategy) {
        return strategy.check(input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        System.out.println("\nChoose a validation algorithm:");
        System.out.println("1. Stack-based (LIFO matching)");
        System.out.println("2. Deque-based (Front & Rear matching)");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        // Declare the interface type, not the concrete class
        PalindromeStrategy selectedStrategy;

        // Dynamically assign the strategy based on user input
        if (choice == 1) {
            selectedStrategy = new StackStrategy();
            System.out.println("--> Executing Stack Strategy...");
        } else {
            selectedStrategy = new DequeStrategy();
            System.out.println("--> Executing Deque Strategy...");
        }

        // Pass the chosen strategy into our execution context
        boolean result = executeStrategy(userInput, selectedStrategy);

        System.out.println("\n--- Output ---");
        if (result) {
            System.out.println("Result: '" + userInput + "' IS a palindrome.");
        } else {
            System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}