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
        int cotad = getCotaDerecha(x0, y0, tablero);
        int cotai = getCotaIzquierda(x0, y0, tablero);
        int cotasu = getCotaSuper(x0, y0, tablero);
        int cotain = getCotaInfer(x0, y0, tablero);
        boolean torre = (x0 == x1 && y0 != y1 && y1 < cotain && y1 > cotasu) || (y0 == y1 && x0 != x1 && x1 < cotad && x1 > cotai);
        return (x1 + y1 == x0 + y0) || (x1 - y1 == x0 - y0) || torre;
    }
}
