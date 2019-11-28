import java.beans.PropertyChangeSupport;

public class Principal {

    Principal() {

        // Jugador A true => Jugador de abajo. False => Jugador de arriba.
        Pieza[][] tablero = new Pieza[8][8];
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(1, i, true, tablero);
        }
        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(1, i, false, tablero);
        }
        // Piezas del jugador A
        tablero[0][0] = new Torre(0, 0, true);
        tablero[0][1] = new Caballo(1, 0, true);
        tablero[0][2] = new Alfil(2, 0, true);
        tablero[0][3] = new Reina(3, 0, true);
        tablero[0][4] = new Rey(4,0, true);
        tablero[0][5] = new Alfil(5, 0, true);
        tablero[0][6] = new Caballo(6, 0, true);
        tablero[0][7] = new Torre(7, 0, true);
        // Piezas del jugador B
        tablero[7][0] = new Torre(0, 0, false);
        tablero[7][1] = new Caballo(1, 0, false);
        tablero[7][2] = new Alfil(2, 0, false);
        tablero[7][3] = new Reina(3, 0, false);
        tablero[7][4] = new Rey(4,0, false);
        tablero[7][5] = new Alfil(5, 0, false);
        tablero[7][6] = new Caballo(6, 0, false);
        tablero[7][7] = new Torre(7, 0, false);

        PropertyChangeSupport supportModelo = new PropertyChangeSupport(this);

        Modelo modelo = new Modelo(supportModelo, tablero);
        modelo.print();
    }

    public static void main(String[] args) {
        new Principal();
    }
}
