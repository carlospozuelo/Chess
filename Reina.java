public class Reina extends Pieza {

    @Override
    public String toString() {
        return "Q";
    }

    Reina(int x, int y, boolean isJugadorA) {
        super(x, y, isJugadorA);
    }

    @Override
    public boolean aceptable(int x, int y) {
        return false;
    }
}
