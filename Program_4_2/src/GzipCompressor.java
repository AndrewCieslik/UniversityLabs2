import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GzipCompressor {
    public static void compressFile(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             GZIPOutputStream gzos = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                gzos.write(buffer, 0, length);
            }

            System.out.println("Plik został skompresowany do: " + outputFile);
        } catch (IOException e) {
            System.err.println("Błąd podczas kompresji: " + e.getMessage());
        }
    }
}
