public class Reina extends Pieza {

    @Override
    public String toString() {
        return "Q";
    }

    Reina(boolean isJugadorA) {
        super(isJugadorA);
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1) {
        return (x1 + y1 == x0 + y0) || (x1 - y1 == x0 - y0) || (x0 == x1 && y0 != y1) || (y0 == y1 && x0 != x1);
    }
}
