public class Reina extends Pieza {

    @Override
    public String toString() {
        return "Q";
    }

    Reina(boolean isJugadorA) {
        super(isJugadorA);
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        return alfil(x0, y0, x1, y1, tablero) || torre(x0, y0, x1, y1, tablero);
    }
}
