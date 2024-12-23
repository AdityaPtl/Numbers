import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

class FindEToNthDigit {
    public static void main (String[] args){
        // gathering the input and limiting to 15 digits for precision
        Scanner numIN = new Scanner(System.in);
        System.out.println("Input the digit to which you would like e (Max 100 digits)");
        int n = numIN.nextInt();

        // handling n to avoid precision errors
        if (n > 100) {
            System.out.println("Maximum precision limit of 100 digits has been exceeded, defaulting to output of 100 digits");
            n = 100;
        } else if (n < 0) {
            System.out.println("Minimum precision limit of 1 digits has not been achieved, defaulting to output of 1 digit");
            n = 1;
        }

        // calculating output and outputting it
        BigDecimal e = calculateE(n + 1)
        System.out.println("e to " + n + " decimal places is: ");
        System.out.println(e.setScale(n, BigDecimal.ROUND_FLOOR));

    }
    public static BigDecimal calculateE (int n) {
        MathContext mc = new MathContext(precision + 5);
        BigDecimal e = BigDecimal.ONE;
        BigDecimal factorial = BigDecimal.ONE;
        int i = 1;
        
        while (true) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
            BigDecimal term = BigDecimal.ONE.divide(factorial, mc);
            
            if (term.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
            
            e = e.add(term);
            i++;
        }
        return e;

    }
}