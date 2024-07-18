public class Main {
    public static void main(String[] args) {
        KolejkaKomunikatow k = new KolejkaKomunikatow();
        Watek w1 = new Watek(k, 1, "w1-");
        Watek w2 = new Watek(k, 2, "w2-");

        w1.start();
        w2.start();

        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (!k.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                Integer ob1 = k.odbierz("w1-" + i);
                if (ob1 != null) {
                    System.out.println("w1-" + i + ": " + ob1);
                }
                Integer ob2 = k.odbierz("w2-" + i);
                if (ob2 != null) {
                    System.out.println("w2-" + i + ": " + ob2);
                }
            }
        }
    }
}
