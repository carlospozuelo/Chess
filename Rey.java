public class Rey extends Pieza {

    Rey(boolean jugadorA) {
        super(jugadorA);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean aceptable(int x0, int y0, int x, int y) {
        if (x0 == x + 1 && y0 == y + 1 ) {
            return true;
        }
        if (x0 == x + 1 && y0 == y) {
            return true;
        }
        if (x0 == x + 1 && y0 == y - 1 ) {
            return true;
        }
        if (x0 == x - 1 && y0 == y + 1) {
            return true;
        }
        if (x0 == x - 1 && y0 == y) {
            return true;
        }
        if (x0 == x - 1 && y0 == y - 1) {
            return true;
        }
        if (x0 == x && y0 == y + 1) {
            return true;
        }
        if (x0 == x && y0 == y - 1) {
            return true;
        }
        return false;
    }
}
