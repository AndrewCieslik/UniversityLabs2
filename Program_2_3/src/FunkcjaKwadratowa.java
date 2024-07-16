public class FunkcjaKwadratowa extends Wielomian {
    private double a;
    private double b;
    private double c;

    public FunkcjaKwadratowa(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void wypiszMiejscaZerowe() {
        // Obliczanie delty
        double delta = b * b - 4 * a * c;

        // Wyznaczenie miejsc zerowych
        if (delta < 0) {
            System.out.println("brak");
        } else if (delta == 0) {
            double miejsceZerowe = -b / (2 * a);
            System.out.println(miejsceZerowe);
        } else {
            double miejsceZerowe1 = (-b - Math.sqrt(delta)) / (2 * a);
            double miejsceZerowe2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.println(miejsceZerowe1 + " " + miejsceZerowe2);
        }
    }
}
