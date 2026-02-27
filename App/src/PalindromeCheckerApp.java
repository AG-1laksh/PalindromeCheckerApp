import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check String Palindrome
    public static boolean isStringPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check Number Palindrome
    public static boolean isNumberPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker App =====");
        System.out.println("1. Check String Palindrome");
        System.out.println("2. Check Number Palindrome");
        System.out.print("Choose option (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {

            case 1:
                System.out.print("Enter a string: ");
                String input = scanner.nextLine();

                if (isStringPalindrome(input)) {
                    System.out.println("It is a String Palindrome ");
                } else {
                    System.out.println("It is NOT a String Palindrome ");
                }
                break;

            case 2:
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();

                if (isNumberPalindrome(number)) {
                    System.out.println("It is a Number Palindrome ");
                } else {
                    System.out.println("It is NOT a Number Palindrome ");
                }
                break;

            default:
                System.out.println("Invalid choice ");
        }

        scanner.close();
    }
}