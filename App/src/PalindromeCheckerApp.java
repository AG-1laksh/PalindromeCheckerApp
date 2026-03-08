import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckerApp {
    // Method to validate palindrome comparing Stack (LIFO) and Queue (FIFO)
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        // Initialize the Stack and Queue
        Stack<Character> stack = new Stack<>();
        // Note: Queue is an interface in Java, so we implement it using a LinkedList
        Queue<Character> queue = new LinkedList<>();

        // 1. Push characters to stack AND Enqueue characters to queue
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c); // Pushes to the top of the stack
            queue.add(c);  // Enqueues to the back of the queue
        }

        // 2. Compare dequeue vs pop
        // Pop removes from the top (reverse order), Remove (dequeue) removes from the front (original order)
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char poppedChar = stack.pop();
            char dequeuedChar = queue.remove();

            // 3. Logical Comparison
            if (poppedChar != dequeuedChar) {
                return false; // Mismatch means it's not a palindrome
            }
        }

        return true; // No mismatches found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' IS a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

}
    // Method to check String Palindrome




