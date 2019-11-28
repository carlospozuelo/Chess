import javafx.scene.image.Image;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Vista extends Canvas implements PropertyChangeListener {

    private Graphics2D g2d;
    private boolean[][] validez;
    private Pieza[][] tablero;
    private static double offset = 0.3;


    public static int CELLSIZE = 40;

    Vista(Pieza[][] tablero, boolean[][] validez) {
        this.tablero = tablero; this.validez = validez;
    }

    @Override
    public void paint(Graphics g) {
        this.g2d = (Graphics2D) g;
        g2d.setFont(new Font("Comic Sans MS", Font.PLAIN, (int) (CELLSIZE - (CELLSIZE * offset))));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (validez[i][j]) {
                    g2d.setColor(Color.GREEN);
                } else if ((i + j) % 2 == 0) {
                    g2d.setColor(Color.decode("#c0a878"));
                } else {
                    g2d.setColor(Color.decode("#a89060"));
                }
                g2d.fillRect(i * CELLSIZE, j * CELLSIZE, CELLSIZE, CELLSIZE);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null) {
                    if (tablero[i][j].isJugadorA()) g2d.setColor(Color.black);
                    else g2d.setColor(Color.white);
                    g2d.drawString(tablero[i][j].toString(), (j * CELLSIZE) + (int) ((offset/2) * CELLSIZE), ((i + 1) * CELLSIZE) - (int) ((offset/2) * CELLSIZE));
                }
            }
        }
    }

    public void vaciar() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                validez[i][j] = false;
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals("validez")) {

        }
        if (e.getPropertyName().equals("soltar")) {
            vaciar();
        }
        repaint();
    }
}
