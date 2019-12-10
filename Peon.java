public class Peon extends Pieza {

    private Pieza[][] tablero;

    @Override
    public String toString() {
        return "P";
    }

    Peon(boolean isJugadorA, Pieza[][] tablero) {
        super(isJugadorA);
        this.tablero = tablero;
    }

    @Override
    public boolean aceptable(int x, int y, int x1, int y1, Pieza[][] tablero) {
        boolean aceptable = false;
        if (!super.isJugadorA() && y == 6 && tablero[5][x1] == null && tablero[4][x1] == null) {
            // Puede moverse DOS HACIA ARRIBA (es el jugador de abajo)
            aceptable = y1 == y - 2 && x == x1;
        }
        if (super.isJugadorA() && y == 1 && tablero[2][x1] == null && tablero[3][x1] == null) {
            // Puede moverse DOS hacia ABAJO (es el jugador de ARRIBA)
            aceptable = y1 == y + 2 && x == x1;
        }
        // Es un movimiento normal y corriente
        if (!super.isJugadorA()) {
            // Puede moverse UNO hacia ARRIBA (es el jugador de abajo)
            if (y == y1 + 1) {
                if (x == x1 && tablero[y1][x1] == null) aceptable = true;
                aceptable = aceptable || comerDiagonal(x, y, x1, y1, tablero);
            }
        } else {
            if (y == y1 - 1) {
                if (x == x1 && tablero[y1][x1] == null) aceptable = true;
                aceptable = aceptable || comerDiagonal(x, y, x1, y1, tablero);
            }
        }
        return aceptable;
    }

    private boolean comerDiagonal(int x, int y, int x1, int y1, Pieza[][] tablero) {
        boolean aceptable = false;
        if (x == x1 + 1) {
            if (tablero[y1][x1] != null && tablero[y1][x1].isJugadorA() != isJugadorA()) {
                aceptable = true;
            }
        }
        if (x == x1 - 1) {
            if (tablero[y1][x1] != null && tablero[y1][x1].isJugadorA() != isJugadorA()) {
                aceptable = true;
            }
        }
        return aceptable;
    }
}
