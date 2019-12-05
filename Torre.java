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
        return torre(x0, y0, x, y, tablero);
    }
}
