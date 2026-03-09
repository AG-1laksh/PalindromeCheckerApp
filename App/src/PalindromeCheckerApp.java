import java.util.Stack;

public class PalindromeCheckerApp {

    // Algorithm 1: Two-Pointer (Highly optimized, O(1) space)
    public static boolean checkTwoPointer(String str) {
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

    // Algorithm 2: Built-in StringBuilder (Convenient, but O(N) space)
    public static boolean checkStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    // Algorithm 3: Stack-based (Slower due to object creation overhead)
    public static boolean checkStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i)); // Autoboxing char to Character adds overhead
        }
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 1. Generate a massive palindrome for noticeable performance differences
        int size = 100000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append('a');
        }
        String testString = sb.toString();

        System.out.println("Starting Performance Comparison (String length: " + size + ")...\n");

        // Warm-up the JVM: Running them once before measuring ensures the
        // Java Just-In-Time (JIT) compiler optimizes the code fairly.
        checkTwoPointer(testString);
        checkStringBuilder(testString);
        checkStack(testString);

        // 2. Run Multiple Algorithms & Capture Execution Time

        // Test 1: Two-Pointer
        long start1 = System.nanoTime();
        checkTwoPointer(testString);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Test 2: StringBuilder
        long start2 = System.nanoTime();
        checkStringBuilder(testString);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Test 3: Stack
        long start3 = System.nanoTime();
        checkStack(testString);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // 3. Display Results
        System.out.println("--- Execution Times (in nanoseconds) ---");
        System.out.println("1. Two-Pointer Approach   : " + time1 + " ns");
        System.out.println("2. StringBuilder Approach : " + time2 + " ns");
        System.out.println("3. Stack Approach         : " + time3 + " ns");

        System.out.println("\n(Note: Lower time is better. 1 millisecond = 1,000,000 nanoseconds)");
    }
}