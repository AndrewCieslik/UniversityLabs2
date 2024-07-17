import javax.swing.*;

class Cenzor extends Thread {
    JTextArea okno;
    volatile boolean zakonczyc;
    String niecenzuralneSlowo = "cholera";

    public Cenzor(JTextArea comp) {
        okno = comp;
        zakonczyc = false;
    }

    public void run() {
        while (!zakonczyc) {
            try {
                String tekst = okno.getText();
                if (tekst.contains(niecenzuralneSlowo)) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono niecenzuralne słowo: " + niecenzuralneSlowo);
                }
                sleep(10000); // Sprawdzanie co 10 sekund
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
