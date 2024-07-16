public class Rational {
    private int numerator;   // licznik
    private int denominator; // mianownik

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerem.");
        }

        // Upewnienie się, że mianownik jest zawsze dodatni
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        // Skrócenie ułamka
        int gcd = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // Metoda pomocnicza do obliczania największego wspólnego dzielnika (GCD)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Dodawanie
    public Rational add(Rational arg) {
        int num = this.numerator * arg.denominator + arg.numerator * this.denominator;
        int den = this.denominator * arg.denominator;
        return new Rational(num, den);
    }

    // Mnożenie
    public Rational mul(Rational arg) {
        int num = this.numerator * arg.numerator;
        int den = this.denominator * arg.denominator;
        return new Rational(num, den);
    }

    // Odejmowanie
    public Rational sub(Rational arg) {
        int num = this.numerator * arg.denominator - arg.numerator * this.denominator;
        int den = this.denominator * arg.denominator;
        return new Rational(num, den);
    }

    // Dzielenie
    public Rational div(Rational arg) {
        int num = this.numerator * arg.denominator;
        int den = this.denominator * arg.numerator;
        return new Rational(num, den);
    }

    // Równość
    public boolean equals(Rational arg) {
        // Sprawdzenie równości ułamków po ich uproszczeniu
        return this.numerator == arg.numerator && this.denominator == arg.denominator;
    }

    // Porównanie
    public int compareTo(Rational arg) {
        // Aby porównać, zamieniamy ułamki na wspólny mianownik
        int thisNum = this.numerator * arg.denominator;
        int argNum = arg.numerator * this.denominator;

        if (thisNum < argNum) {
            return -1;
        } else if (thisNum > argNum) {
            return 1;
        } else {
            return 0;
        }
    }

    // Tekstowa reprezentacja liczby
    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);  // Jeśli mianownik jest równy 1, zwracamy tylko licznik
        } else {
            return numerator + "/" + denominator;
        }
    }
}