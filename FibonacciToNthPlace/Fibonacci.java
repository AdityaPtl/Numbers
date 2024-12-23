import java.util.Scanner;

public class Fibonacci {

    public static void main (String[] args){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter which number of the fibonacci sequence you want (max 45): ");
        int n = myObj.nextInt();

        if (n < 1) {
            System.out.println("error: value must be greater than or equal to 1, defaulting to n=1");
            n = 1;
        }

        if (n > 100) {
            System.out.println("error: value must be less than or equal to 45, defaulting to n=100");
            n = 45;
        }

        int out = calculateFibNum(n);
        System.out.println("The " + getOrdinal(n) + " Fibonacci number is: " + out);
    }

    public static int calculateFibNum (int n) {
        if (n == 0){
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3){
            return 2;
        }

        else {
            return calculateFibNum(n-1) + calculateFibNum(n-2);
        }

    }

    public static String getOrdinal(int n) {
        if (n >= 11 && n <= 13) {
            return n + "th";
        }
        switch (n % 10) {
            case 1: return n + "st";
            case 2: return n + "nd";
            case 3: return n + "rd";
            default: return n + "th";
        }
    }
    
    
}
