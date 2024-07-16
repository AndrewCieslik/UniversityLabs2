import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("For the equation y = Ax^2 - Bx + C:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter B");
        int b = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter C");
        int c = scanner.nextInt();
        scanner.nextLine();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        System.out.println("Enter x");
        double x = scanner.nextDouble();
        scanner.nextLine();

        double y = equation.calculateY(x);
        System.out.println("For x = " + x + ", y = " + y);

        int roots = equation.numberOfRoots();
        System.out.println("Number of roots: " + roots);
    }
}