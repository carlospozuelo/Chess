import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLOutput;

public class Modelo implements PropertyChangeListener {

    private Pieza[][] tablero;
    private Point2D aux;
    PropertyChangeSupport support;

    Modelo(PropertyChangeSupport support, Pieza[][] tablero) {
        this.support = support;
        this.tablero = tablero;
    }

    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null)
                System.out.print(tablero[i][j].toString() + " ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    private int getX(Point2D punto) {
        return (int) (punto.getX() / Vista.CELLSIZE);
    }

    private int getY(Point2D punto) {
        return (int) (punto.getY() / Vista.CELLSIZE);
    }

    private boolean valido(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("click")) {
            this.aux = (Point2D) evt.getNewValue();
        }
        if (evt.getPropertyName().equals("release")) {
            Point2D destino = (Point2D) evt.getNewValue();
            int x0 = getX(aux); int y0 = getY(aux);
            int x1 = getX(destino); int y1 = getY(destino);
            System.out.println("Origen: [x=" + x0 + ", y=" + y0 + "]. Destino: [x="+ x1 + ", y=" + y1 + "]");
            if (valido(x0, y0) && tablero[y0][x0] != null) {
                // La casilla inicial es valida
                if (valido(x1, y1) && (tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != tablero[y0][x0].isJugadorA())) {
                    // El destino es valido (dentro del tablero, movimiento aceptable y sin pieza o con una pieza enemiga)
                    if (tablero[y0][x0].aceptable(x0, y0, x1, y1)) {
                        tablero[y1][x1] = tablero[y0][x0];
                        tablero[getY(aux)][getX(aux)] = null;
                        support.firePropertyChange("movimiento", false, true);
                    }
                }
            }
        }
    }
}
