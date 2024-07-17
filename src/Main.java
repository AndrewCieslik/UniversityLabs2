import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GZIP Compressor/Decompressor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Choose an option:");
        userLabel.setBounds(10, 20, 160, 25);
        panel.add(userLabel);

        JButton compressButton = new JButton("Compress File");
        compressButton.setBounds(10, 50, 120, 25);
        panel.add(compressButton);

        JButton decompressButton = new JButton("Decompress File");
        decompressButton.setBounds(150, 50, 120, 25);
        panel.add(decompressButton);

        compressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(panel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    compressFile(selectedFile);
                }
            }
        });

        decompressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(panel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    decompressFile(selectedFile);
                }
            }
        });
    }

    private static void compressFile(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(file.getPath() + ".gz");
             GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, len);
            }
            JOptionPane.showMessageDialog(null, "File compressed successfully!");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error compressing file: " + ex.getMessage());
        }
    }

    private static void decompressFile(File file) {
        if (!file.getName().endsWith(".gz")) {
            JOptionPane.showMessageDialog(null, "Selected file is not a GZIP file.");
            return;
        }

        String outputFilePath = file.getPath().substring(0, file.getPath().lastIndexOf('.'));

        try (FileInputStream fis = new FileInputStream(file);
             GZIPInputStream gzipIS = new GZIPInputStream(fis);
             FileOutputStream fos = new FileOutputStream(outputFilePath)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipIS.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            JOptionPane.showMessageDialog(null, "File decompressed successfully!");

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error decompressing file: " + ex.getMessage());
        }
    }
}
