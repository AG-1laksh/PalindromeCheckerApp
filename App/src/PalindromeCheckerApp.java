import java.util.Scanner;
import java.util.Deque;      // ADDED: This import is required to use the Deque interface
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Method to check String Palindrome using a Deque
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(String input) {
        // Optional: Clean the input string
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Edge case: Empty string or single character is a palindrome
        if (cleanInput.length() <= 1) {
            return true;
        }

        // 1. Convert string to linked list
        Node head = new Node(cleanInput.charAt(0));
        Node current = head;
        for (int i = 1; i < cleanInput.length(); i++) {
            current.next = new Node(cleanInput.charAt(i));
            current = current.next;
        }

        // 2. Find the middle using the Fast and Slow Pointer Technique
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Moves 1 step
            fast = fast.next.next;   // Moves 2 steps
        }
        // When 'fast' reaches the end, 'slow' is at the middle.

        // 3. In-Place Reversal of the second half
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // 'prev' is now the head of the reversed second half
        Node secondHalfHead = prev;

        // 4. Compare halves
        Node firstHalfHead = head;
        while (secondHalfHead != null) {
            if (firstHalfHead.data != secondHalfHead.data) {
                return false; // Mismatch found
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

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