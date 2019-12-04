public class Torre extends Pieza {

    Torre(boolean jugadorA) {
         super(jugadorA);
    }

    @Override
    public String toString() {
        return "T";
    }


    @Override
    public boolean aceptable(int x0, int y0, int x, int y, Pieza[][] tablero) {
        int cotad = getCotaDerecha(x0, y0, tablero);
        int cotai = getCotaIzquierda(x0, y0, tablero);
        int cotain = getCotaInfer(x0, y0, tablero);
        int cotasu = getCotaSuper(x0, y0, tablero);
        return (x0 == x && y0 != y && y < cotain && y > cotasu) || (y0 == y && x0 != x && x < cotad && x > cotai);
    }
}
