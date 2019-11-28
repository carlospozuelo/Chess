public class Torre extends Pieza {

    Torre(boolean jugadorA) {
         super(jugadorA);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean aceptable(int x0, int y0, int x, int y) {
        return (x0 == x && y0 != y) || (y0 == y && x0 != x);
    }
}
