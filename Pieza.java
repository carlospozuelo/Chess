public abstract class Pieza {
    private boolean jugadorA;

    public boolean isJugadorA() {
        return jugadorA;
    }

    Pieza(boolean jugadorA) {
        this.jugadorA = jugadorA;
    }

    public abstract String toString();

    public abstract boolean aceptable(int x0, int y0, int x1, int y1);
}
