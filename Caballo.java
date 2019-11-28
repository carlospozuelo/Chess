public class Caballo extends Pieza {

    Caballo(int x, int y, boolean jugadorA) {
        super(x, y, jugadorA);
    }

    @Override
    public String toString() {
        return "C";
    }

    @Override
    public boolean aceptable(int x, int y) {
        if (super.getX() == x + 1 && super.getY() == y + 2 ) {
            return true;
        }
        if (super.getX() == x + 1 && super.getY() == y - 2) {
            return true;
        }
        if (super.getX() == x - 1 && super.getY() == y + 2 ) {
            return true;
        }
        if (super.getX() == x - 1 && super.getY() == y - 2) {
            return true;
        }
        if (super.getX() == x + 2 && super.getY() == y + 1) {
            return true;
        }
        if (super.getX() == x + 2 && super.getY() == y - 1) {
            return true;
        }
        if (super.getX() == x - 2 && super.getY() == y + 1) {
            return true;
        }
        if (super.getX() == x - 2&& super.getY() == y - 1) {
            return true;
        }
        return false;
    }
}
