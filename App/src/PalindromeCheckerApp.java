import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        // Clean the string (optional, but good practice): remove spaces and make lowercase
        // str = str.replaceAll("\\s+", "").toLowerCase();

        // 1. Convert string to char[]
        char[] charArray = str.toCharArray();

        // 2. Initialize the two pointers
        int left = 0;                  // Starts at the beginning
        int right = charArray.length - 1; // Starts at the end

        // 3. Loop until the two pointers meet in the middle
        while (left < right) {
            // Compare start & end characters
            if (charArray[left] != charArray[right]) {
                return false; // If there's a mismatch, it's not a palindrome
            }
            // Move pointers towards the center
            left++;
            right--;
        }

        return true; // If the loop finishes without mismatches, it is a palindrome
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


    }

}
    // Method to check String Palindrome




