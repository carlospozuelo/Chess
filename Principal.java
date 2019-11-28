import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;

public class Principal {

    Principal() {

        // Jugador A true => Jugador de abajo. False => Jugador de arriba.
        Pieza[][] tablero = new Pieza[8][8];
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(true, tablero);
        }
        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(false, tablero);
        }
        // Piezas del jugador A
        tablero[0][0] = new Torre( true);
        tablero[0][1] = new Caballo( true);
        tablero[0][2] = new Alfil( true);
        tablero[0][3] = new Reina(true);
        tablero[0][4] = new Rey(true);
        tablero[0][5] = new Alfil(true);
        tablero[0][6] = new Caballo( true);
        tablero[0][7] = new Torre(true);
        // Piezas del jugador B
        tablero[7][0] = new Torre( false);
        tablero[7][1] = new Caballo( false);
        tablero[7][2] = new Alfil(false);
        tablero[7][3] = new Reina( false);
        tablero[7][4] = new Rey( false);
        tablero[7][5] = new Alfil( false);
        tablero[7][6] = new Caballo( false);
        tablero[7][7] = new Torre( false);

        PropertyChangeSupport supportModelo = new PropertyChangeSupport(this);
        PropertyChangeSupport supportControlador = new PropertyChangeSupport(this);

        boolean[][] validez = new boolean[8][8];

        Modelo modelo = new Modelo(supportModelo, tablero, validez);
        Vista vista = new Vista(tablero, validez);
        vista.vaciar();
        Controlador controlador = new Controlador(supportControlador);

        supportModelo.addPropertyChangeListener(vista);
        supportControlador.addPropertyChangeListener(modelo);

        vista.addMouseListener(controlador);

        Frame frame = new Frame();
        frame.add(vista);
        frame.setSize(Vista.CELLSIZE * 8 + 30, Vista.CELLSIZE * 8 + 40);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Principal();
    }
}
