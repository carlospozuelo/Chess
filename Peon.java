public class Peon extends Pieza {

    private boolean esPrimer;
    private Pieza[][] tablero;

    @Override
    public String toString() {
        return "P";
    }

    Peon(int x, int y, boolean isJugadorA, Pieza[][] tablero) {
        super(x, y, isJugadorA);
        this.tablero = tablero;
    }

    @Override
    public boolean aceptable(int x, int y) {
        boolean aceptable = false;
        if (esPrimer) {
            // Puede moverse dos hacia delante
            if (super.isJugadorA()) {
                // Puede moverse DOS HACIA ARRIBA (es el jugador de abajo)
                aceptable = super.getY() == y - 2;
            } else {
                // Puede moverse DOS hacia ABAJO (es el jugador de ARRIBA)
                aceptable = super.getY() == y + 2;
            }
        } else {
            // Es un movimiento normal y corriente
            if (super.isJugadorA()) {
                // Puede moverse UNO hacia ARRIBA (es el jugador de abajo)
                aceptable = super.getY() == y - 1;
                // TODO : implementar que el peón pueda comer
            } else {
                // Puede moverse UNO hacia ABAJO (es el jugador de ARRIBA)
                aceptable = super.getY() == y + 1;
                // TODO : implementar que el peón pueda comer
            }
        }
        return aceptable;
    }
}
