public class Peon extends Pieza {

    private boolean esPrimer = true;
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
    public boolean aceptable(int x, int y, int x1, int y1) {
        boolean aceptable = false;
        if (esPrimer) {
            // Puede moverse dos hacia delante
            if (!super.isJugadorA()) {
                // Puede moverse DOS HACIA ARRIBA (es el jugador de abajo)
                aceptable = y1 == y - 2 && x == x1;
            } else {
                // Puede moverse DOS hacia ABAJO (es el jugador de ARRIBA)
                aceptable = y1 == y + 2 && x == x1;
            }
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
        // TODO : arreglar ES PRIMER
        esPrimer = esPrimer && !aceptable;
        return aceptable;
    }
}
