public class Torre extends Pieza {

    Torre(int x, int y, boolean jugadorA) {
         super(x, y, jugadorA);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean aceptable(int x, int y) {
        return (super.getX() == x && super.getY() != y) || (super.getY() == y && super.getX() != x);
    }
}
