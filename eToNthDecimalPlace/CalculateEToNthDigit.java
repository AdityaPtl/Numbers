import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalculateEToNthDigit {

    // Limit for the maximum number of digits
    private static final int MAX_DIGITS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of decimal places for e (max 100): ");
        int n = scanner.nextInt();
        
        if (n > MAX_DIGITS) {
            System.out.println("Limit exceeded. Setting to maximum of 100 decimal places.");
            n = MAX_DIGITS;
        }

        if (n < 0) {
            System.out.println("Invalid input. Please enter a non-negative number.");
            return;
        }

        BigDecimal e = calculateE(n + 5); // Calculate a few extra digits to avoid rounding errors
        e = e.setScale(n, RoundingMode.HALF_UP);
        
        System.out.println("e to " + n + " decimal places: ");
        System.out.println(e);
    }

    // Function to calculate e using the series expansion
    private static BigDecimal calculateE(int precision) {
        BigDecimal e = BigDecimal.ONE;
        BigDecimal factorial = BigDecimal.ONE;
        
        for (int i = 1; i < precision; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i)); //calculates the current factorial
            e = e.add(BigDecimal.ONE.divide(factorial, new MathContext(precision + 10))); // calculates the inverse of the factorial and adds it to the running value of e, the mathcontext ensures the divison is done with high precision
        }
        
        return e;
    }
}
