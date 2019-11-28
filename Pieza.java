public abstract class Pieza {
    private int x, y;
    private boolean jugadorA;

    public boolean isJugadorA() {
        return jugadorA;
    }

    Pieza(int x, int y, boolean jugadorA) {
        setX(x); setY(y); this.jugadorA = jugadorA;
    }

    public abstract String toString();

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract boolean aceptable(int x, int y);
}
