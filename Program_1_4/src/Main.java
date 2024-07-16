import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int number = scanner.nextInt();
        System.out.println("Binary: " + toBinaryString(number));
        System.out.println("Octal: " + toOctalString(number));
        System.out.println("Hex: " + toHexString(number));
    }

    public static String toBinaryString(int number) {
        if (number == 0) return "0";

        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.insert(0, (number & 1));
            number >>= 1;
        }
        return binary.toString();
    }

    public static String toOctalString(int number) {
        if (number == 0) return "0";

        StringBuilder octal = new StringBuilder();
        while (number > 0) {
            octal.insert(0, (number % 8));
            number /= 8;
        }
        return octal.toString();
    }

    public static String toHexString(int number) {
        if (number == 0) return "0";

        char[] hexDigits = "0123456789ABCDEF".toCharArray();
        StringBuilder hex = new StringBuilder();
        while (number > 0) {
            hex.insert(0, hexDigits[number % 16]);
            number /= 16;
        }
        return hex.toString();
    }
}