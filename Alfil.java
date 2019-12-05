public class Alfil extends Pieza {

    Alfil(boolean isJugadorA) {
        super(isJugadorA);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        return alfil(x0, y0, x1, y1, tablero);
    }
}
