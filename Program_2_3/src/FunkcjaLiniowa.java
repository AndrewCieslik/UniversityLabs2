public class FunkcjaLiniowa extends Wielomian {
    private double a;
    private double b;

    public FunkcjaLiniowa(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void wypiszMiejscaZerowe() {
        // Miejsce zerowe dla funkcji liniowej ax + b = 0
        if (a == 0) {
            System.out.println("brak");
        } else {
            double miejsceZerowe = -b / a;
            System.out.println(miejsceZerowe);
        }
    }
}
