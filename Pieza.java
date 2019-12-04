import java.awt.geom.Point2D;

public abstract class Pieza {
    private boolean jugadorA;

    public boolean isJugadorA() {
        return jugadorA;
    }

    Pieza(boolean jugadorA) {
        this.jugadorA = jugadorA;
    }

    // TODO: FIX DUPLICATE CODE

    public int getCotaDerecha(int x0, int y0, Pieza[][] tablero) {
        int cota = 7;
        int i = x0 + 1;
        while(i < tablero.length && cota == 7) {
            if (tablero[y0][i] != null)
                cota = i;
            i++;
        }
        cota = tablero[y0][cota] == null ? cota + 1 : tablero[y0][cota].isJugadorA() != isJugadorA() ? cota + 1 : cota;
        return cota;
    }

    public int getCotaIzquierda(int x0, int y0, Pieza[][] tablero) {
        int cota = 0;
        int i = x0 - 1;
        while(i > 0 && cota == 0) {
            if (tablero[y0][i] != null) {
                cota = i;
            }
            i--;
        }
        cota = tablero[y0][cota] == null ? cota - 1 : tablero[y0][cota].isJugadorA() != jugadorA ? cota - 1: cota;
        return cota;
    }

    public int getCotaInfer(int x0, int y0, Pieza[][] tablero) {
        int cota = 7;
        int i = y0 + 1;
        while(i < tablero.length && cota == 7) {
            if (tablero[i][x0] != null)
                cota = i;
            i++;
        }
        cota = tablero[cota][x0] == null ? cota + 1: tablero[cota][x0].isJugadorA() != isJugadorA() ? cota + 1: cota;
        return cota;
    }

    public int getCotaSuper(int x0, int y0, Pieza[][] tablero) {
        int cota = 0;
        int i = y0 - 1;
        while(i > 0 && cota == 0) {
            if (tablero[i][x0] != null)
                cota = i;
            i--;
        }
        cota = tablero[cota][x0] == null ? cota - 1: tablero[cota][x0].isJugadorA() != isJugadorA() ? cota - 1: cota;
        return cota;
    }


    public Point2D getCotaPrimer(int x0, int y0, Pieza[][] tablero) {
        Point2D cota = new Point2D.Double(x0, y0);
        boolean cambiado = false;
        int contador = 0;
        while(y0 - 1 - contador >= 0 && x0 - 1 - contador >= 0 && !cambiado) {
            if (tablero[y0-1-contador][x0-contador-1] != null) {
                if (tablero[y0-1-contador][x0-contador-1].isJugadorA() != isJugadorA())
                    cota.setLocation(x0 - 1 - contador, y0 - 1 - contador);
                else cota.setLocation(x0 - contador, y0 - contador);
                cambiado = true;
            }
            contador++;
        }
        return cota;
    }

    public abstract String toString();

    public abstract boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero);
}
