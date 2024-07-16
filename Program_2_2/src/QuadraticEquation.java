public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    // Konstruktor
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metoda ustawiająca współczynniki
    public void setCoefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metoda obliczająca wartość y dla danego x
    public double calculateY(double x) {
        return a * x * x + b * x + c;
    }

    // Metoda wyznaczająca liczbę pierwiastków
    public int numberOfRoots() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return 0; // Brak pierwiastków
        } else if (discriminant == 0) {
            return 1; // Jeden podwójny pierwiastek
        } else {
            return 2; // Dwa pierwiastki
        }
    }
}