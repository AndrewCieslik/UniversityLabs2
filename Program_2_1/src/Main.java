import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a first numerator: ");
        int num1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a first denominator: ");
        int den1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a second numerator: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter a second denominator: ");
        int den2 = scanner.nextInt();
        scanner.nextLine();

        Rational r1 = new Rational(num1, den1);
        Rational r2 = new Rational(num2, den2);

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.sub(r2));
        System.out.println("r1 * r2 = " + r1.mul(r2));
        System.out.println("r1 / r2 = " + r1.div(r2));
        System.out.println("r1 equals r2? " + r1.equals(r2));
        System.out.println("r1 compareTo r2: " + r1.compareTo(r2));
    }
}

