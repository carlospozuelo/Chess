public class Caballo extends Pieza {

    Caballo(boolean jugadorA) {
        super(jugadorA);
    }

    @Override
    public String toString() {
        return "C";
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1) {
        if (x1 == x0 + 1 && y1 == y0 + 2 ) {
            return true;
        }
        if (x1 == x0 + 1 && y1 == y0 - 2) {
            return true;
        }
        if (x1 == x0 - 1 && y1 == y0 + 2 ) {
            return true;
        }
        if (x1 == x0 - 1 && y1 == y0 - 2) {
            return true;
        }
        if (x1 == x0 + 2 && y1 == y0 + 1) {
            return true;
        }
        if (x1 == x0 + 2 && y1 == y0 - 1) {
            return true;
        }
        if (x1 == x0 - 2 && y1 == y0 + 1) {
            return true;
        }
        if (x1 == x0 - 2&& y1 == y0 - 1) {
            return true;
        }
        return false;
    }
}
