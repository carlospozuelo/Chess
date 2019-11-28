public class Rey extends Pieza {

    Rey(int x, int y, boolean jugadorA) {
        super(x, y, jugadorA);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean aceptable(int x, int y) {
        if (super.getX() == x + 1 && super.getY() == y + 1 ) {
            return true;
        }
        if (super.getX() == x + 1 && super.getY() == y) {
            return true;
        }
        if (super.getX() == x + 1 && super.getY() == y - 1 ) {
            return true;
        }
        if (super.getX() == x - 1 && super.getY() == y + 1) {
            return true;
        }
        if (super.getX() == x - 1 && super.getY() == y) {
            return true;
        }
        if (super.getX() == x - 1 && super.getY() == y - 1) {
            return true;
        }
        if (super.getX() == x && super.getY() == y + 1) {
            return true;
        }
        if (super.getX() == x && super.getY() == y - 1) {
            return true;
        }
        return false;
    }
}
