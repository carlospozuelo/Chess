import javax.swing.*;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLOutput;

public class Modelo implements PropertyChangeListener {

    private Pieza[][] tablero;
    private Point2D aux;
    PropertyChangeSupport support;
    private boolean[][] validez;
    private boolean turno = false;

    Modelo(PropertyChangeSupport support, Pieza[][] tablero, boolean[][] validez) {
        this.support = support;
        this.tablero = tablero;
        this.validez = validez;
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


    private void getValidez(int y, int x) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[y][x].aceptable(x, y, i, j, tablero))
                    this.validez[i][j] = true;
            }
        }
        this.support.firePropertyChange("validez", false, true);
    }

    private void promocion(int x, int y, boolean isJugadorA) {
        String[] options = {"Reina", "Torre", "Alfil", "Caballo"};
        int opcion = JOptionPane.showOptionDialog(null, "¡Tu peón ha llegado hasta el final! Selecciona una ficha para transformarlo",
                "Selecciona una pieza",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(opcion);
        switch(opcion) {
            case 0:
                tablero[y][x] = new Reina(isJugadorA);
                break;
            case 1:
                tablero[y][x] = new Torre(isJugadorA);
                break;
            case 2:
                tablero[y][x] = new Alfil(isJugadorA);
                break;
            case 3:
                tablero[y][x] = new Caballo(isJugadorA);
                break;
            default:
                promocion(x, y, isJugadorA);
                break;
        }
        turno = isJugadorA;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("click")) {
            this.aux = (Point2D) evt.getNewValue();
            int x = getX(aux); int y = getY(aux);
            if (valido(x, y) && tablero[y][x] != null && tablero[y][x].isJugadorA() == this.turno) {
                this.getValidez(y, x);
            }
        }
        if (evt.getPropertyName().equals("release")) {
            Point2D destino = (Point2D) evt.getNewValue();
            int x0 = getX(aux); int y0 = getY(aux);
            int x1 = getX(destino); int y1 = getY(destino);
            if (valido(x0, y0) && tablero[y0][x0] != null) {
                // La casilla inicial es valida
                if (tablero[y0][x0].isJugadorA() == this.turno) {
                    if (valido(x1, y1) && (tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != tablero[y0][x0].isJugadorA())) {
                        // El destino es valido (dentro del tablero, movimiento aceptable y sin pieza o con una pieza enemiga)
                        if (this.validez[x1][y1]) {
                            turno = !turno;
                            if (tablero[y0][x0].toString().equals("P") && tablero[y0][x0].isJugadorA() && y1 == 7)
                                // TODO: DIALOGO PARA CONVERTIR A LA PIEZA EN OTRA
                                promocion(x1, y1, true);
                            if (tablero[y0][x0].toString().equals("P") && !tablero[y0][x0].isJugadorA() && y1 == 0)
                                promocion(x1, y1, false);
                            if (!tablero[y0][x0].toString().equals("P") || (y1 != 7 && y1 != 0)) tablero[y1][x1] = tablero[y0][x0];
                            tablero[y0][x0] = null;
                            support.firePropertyChange("movimiento", false, true);
                        }
                    }
                }
            }
            support.firePropertyChange("soltar", false, true);
        }
    }
}
