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
        if (tablero[y1][x1] == null) {
            if (!super.isJugadorA() && y == 6 && tablero[5][x1] == null) {
                // Puede moverse DOS HACIA ARRIBA (es el jugador de abajo)
                aceptable = y1 == y - 2 && x == x1;
            }
            if (super.isJugadorA() && y == 1 && tablero[2][x1] == null) {
                // Puede moverse DOS hacia ABAJO (es el jugador de ARRIBA)
                aceptable = y1 == y + 2 && x == x1;
            }
            // Es un movimiento normal y corriente
            if (!super.isJugadorA()) {
                // Puede moverse UNO hacia ARRIBA (es el jugador de abajo)
                aceptable = aceptable || (y1 == y - 1 && x == x1);
                // TODO : implementar que el peón pueda comer
            } else {
                // Puede moverse UNO hacia ABAJO (es el jugador de ARRIBA)
                aceptable = aceptable || (y1 == y + 1 && x == x1);
                // TODO : implementar que el peón pueda comer
            }
        }
        return aceptable;
    }
}
