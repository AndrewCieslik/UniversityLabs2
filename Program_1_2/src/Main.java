import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a non-negative integer: ");
        int n = scanner.nextInt();

        BigInteger factorial = calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}