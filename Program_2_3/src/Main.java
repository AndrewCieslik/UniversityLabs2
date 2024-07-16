public class Main {
    public static void main(String[] args) {
        Wielomian w[] = new Wielomian[3];
        w[0] = new FunkcjaLiniowa(2, 1);       // 2x + 1
        w[1] = new FunkcjaKwadratowa(1, -2, 2); // x^2 - 2x + 2
        w[2] = new FunkcjaKwadratowa(1, 0, -1); // x^2 - 1

        for (int i = 0; i < 3; i++) {
            w[i].wypiszMiejscaZerowe();
        }
    }
}

//Nadpisanie występuje, gdy podklasa dostarcza implementację dla metody, która jest już zdefiniowana w jej nadklasie.

//Przeciążenie występuje, gdy klasa definiuje metodę o tej samej nazwie,
//co już istniejąca metoda w tej samej klasie lub nadklasie, ale z różnym zestawem parametrów (inną liczbą lub typami parametrów).