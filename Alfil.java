import java.awt.geom.Point2D;

public class Alfil extends Pieza {

    Alfil(boolean isJugadorA) {
        super(isJugadorA);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        Point2D aux = getCotaPrimer(x0, y0, tablero);
        int primerX = (int) aux.getX(); int primerY = (int) aux.getY();
        return (x1 + y1 == x0 + y0) || (x1 - y1 == x0 - y0 && x1 >= primerX && y1 >= primerY);
    }
}
