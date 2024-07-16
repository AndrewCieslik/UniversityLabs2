class Kolejka {
    static final int N = 5;
    private Object[] tab;
    private int pocz, zaost, lbel;

    public Kolejka() {
        pocz = 0;
        zaost = 0;
        lbel = 0;
        tab = new Object[N];
    }

    void doKolejki(Object el) throws Przepelnienie {
        if (lbel == N) {
            throw new Przepelnienie("Kolejka jest przepełniona!");
        }
        tab[zaost] = el;
        zaost = (zaost + 1) % N;
        ++lbel;
    }

    Object zKolejki() throws Niedomiar {
        if (lbel == 0) {
            throw new Niedomiar("Kolejka jest pusta!");
        }
        int ind = pocz;
        pocz = (pocz + 1) % N;
        --lbel;
        return tab[ind];
    }
}
