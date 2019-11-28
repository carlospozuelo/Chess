import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Modelo implements PropertyChangeListener {

    private Pieza[][] tablero;
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
