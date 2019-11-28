public class Alfil extends Pieza {

    Alfil(int x, int y, boolean isJugadorA) {
        super(x, y, isJugadorA);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public boolean aceptable(int x, int y) {
        return (super.getX() + super.getY() == x + y) || (super.getX() - super.getY() == x - y);
    }
}
