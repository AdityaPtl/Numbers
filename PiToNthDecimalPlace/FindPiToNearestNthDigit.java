import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

class FindPiToNearestNthDigit {
    public static void main (String[] args){
        // gathering the input and limiting to 15 digits for precision
        Scanner numIN = new Scanner(System.in);
        System.out.println("Input the digit to which you would like pi (Max 15 digits)");
        int n = numIN.nextInt();

        // handling n to avoid precision errors
        if (n > 15) {
            System.out.println("Maximum precision limit of 15 digits has been exceeded, defaulting to output of 15 digits");
            n = 15;
        } else if (n < 0) {
            System.out.println("Minimum precision limit of 1 digits has not been achieved, defaulting to output of 1 digit");
            n = 1;
        }

        // calculating output and outputting it
        String out = calculatePiToNthDigit(n);
        System.out.println("Pi to " + n + " decimal places is: " + out);

    }
    public static String calculatePiToNthDigit (int n) {
        BigDecimal pi = new BigDecimal(Math.PI);
        return pi.setScale(n, RoundingMode.DOWN).toString();
    }
}