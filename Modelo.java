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
            System.out.print("click: [" + getY(aux) + ", " + getX(aux) + "]");
            if (valido(getX(aux), getY(aux))) {
                if (tablero[getY(aux)][getX(aux)] != null)
                    System.out.print(". Figura: " + tablero[getY(aux)][getX(aux)].toString());
                else System.out.print(". Casilla vacía.");
            }
            System.out.println();
        }
        if (evt.getPropertyName().equals("release")) {
            Point2D destino = (Point2D) evt.getNewValue();
            if (valido(getX(aux), getY(aux)) && tablero[getY(aux)][getX(aux)] != null) {
                // La casilla inicial es valida
                if (valido(getX(destino), getY(destino)) && (tablero[getY(destino)][getX(destino)] == null || tablero[getY(destino)][getX(destino)].isJugadorA() != tablero[getY(aux)][getX(aux)].isJugadorA())) {
                    // El destino es valido (dentro del tablero, movimiento aceptable y sin pieza o con una pieza enemiga)
                    if (tablero[getY(aux)][getX(aux)].aceptable(getX(destino), getY(destino))) {
                        System.out.println("el movimiento es aceptable");
                    } else  {
                        System.out.println("el movimiento NO es aceptable");
                    }
                    tablero[getY(destino)][getX(destino)] = tablero[getY(aux)][getX(aux)];
                    tablero[getY(aux)][getX(aux)] = null;
                }
            }
            System.out.println("release");
        }
        support.firePropertyChange("", 0, 1);
    }
}
