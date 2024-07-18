import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String hostname;
        if (args.length > 0) {
            hostname = args[0];
        } else {
            hostname = "time-a.nist.gov";
        }

        try {
            Socket socket = new Socket(hostname, 37);
            InputStream inputStream = socket.getInputStream();

            // Odczytaj 4 bajty ze strumienia wejściowego
            byte[] timeBytes = new byte[4];
            int bytesRead = inputStream.read(timeBytes);

            if (bytesRead == 4) {
                // Zamień 4 bajty na wartość typu long
                long secondsSince1900 = ((timeBytes[0] & 0xFFL) << 24) |
                        ((timeBytes[1] & 0xFFL) << 16) |
                        ((timeBytes[2] & 0xFFL) << 8)  |
                        (timeBytes[3] & 0xFFL);

                System.out.println("Sekundy od 1900: " + secondsSince1900);

                // Zamień na sekundy od 1970 (epoka Unix)
                long secondsSince1970 = secondsSince1900 - 2208988800L;
                System.out.println("Sekundy od 1970: " + secondsSince1970);

                // Zamień na milisekundy od 1970
                long millisecondsSince1970 = secondsSince1970 * 1000;
                System.out.println("Milisekundy od 1970: " + millisecondsSince1970);

                // Utwórz obiekt Date z milisekund od 1970
                java.util.Date date = new java.util.Date(millisecondsSince1970);
                System.out.println("Aktualna data i czas: " + date);
            } else {
                System.err.println("Nie udało się odczytać 4 bajtów z serwera");
            }

            inputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Nieznany host: " + hostname);
        } catch (IOException e) {
            System.err.println("Błąd IO wejścia/wyjścia: " + e.getMessage());
        }
    }
}
