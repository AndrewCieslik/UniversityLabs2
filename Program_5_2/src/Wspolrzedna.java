import java.util.Objects;

class Wspolrzedna implements Comparable<Wspolrzedna> {
    private int x, y;

    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Wspolrzedna other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Wspolrzedna other = (Wspolrzedna) obj;
        return x == other.x && y == other.y;
    }
}