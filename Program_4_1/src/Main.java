import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz standard kodowania:");
        System.out.println("1. UTF-8");
        System.out.println("2. ISO-8859-2");
        System.out.println("3. windows-1250");
        System.out.print("Twój wybór: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String encoding;
        switch (choice) {
            case 1:
                encoding = "UTF-8";
                break;
            case 2:
                encoding = "ISO-8859-2";
                break;
            case 3:
                encoding = "windows-1250";
                break;
            default:
                System.out.println("Niepoprawny wybór, użyto domyślnie UTF-8.");
                encoding = "UTF-8";
                break;
        }

        System.out.print("Wprowadź tekst: ");
        String text = scanner.nextLine();

        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding);
            osw.write(text);
            osw.close();
            System.out.println("Tekst został zapisany do pliku 'output.txt' z użyciem kodowania " + encoding);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }
}