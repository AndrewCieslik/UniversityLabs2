import java.util.HashMap;

class KolejkaKomunikatow {
    private final HashMap<String, Integer> mapa = new HashMap<>();

    public synchronized void wyslij(String klucz, Integer wartosc) {
        mapa.put(klucz, wartosc);
    }

    public synchronized Integer odbierz(String klucz) {
        return mapa.remove(klucz);
    }

    public synchronized boolean isEmpty() {
        return mapa.isEmpty();
    }
}
