class Watek extends Thread {
    private KolejkaKomunikatow koko;
    private int istart;
    private String prefix;

    public Watek(KolejkaKomunikatow kk, int pocz, String prefix) {
        koko = kk;
        istart = pocz;
        this.prefix = prefix;
    }

    public void run() {
        try {
            for (int i = istart; i <= 10; i += 2) {
                koko.wyslij(prefix + i, i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
