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


    public Point2D getCotaSegun(int x0, int y0, Pieza[][] tablero) {
        Point2D cota = new Point2D.Double(x0, y0);
        boolean cambiado = false;
        int contador = 0;
        while(y0 - 1 - contador >= 0 && x0 - 1 - contador >= 0 && !cambiado) {
            if (tablero[y0-1-contador][x0-contador-1] != null) {
                if (tablero[y0-1-contador][x0-contador-1].isJugadorA() != isJugadorA())
                    cota.setLocation(x0 - 1 - contador, y0 - 1 - contador);
                else cota.setLocation(x0 - contador, y0 - contador);
                cambiado = true;
            } else if (x0 - 1 - contador == 0 || y0 - 1 - contador == 0) {
                cota.setLocation(x0 - 1 - contador, y0 - 1 - contador);
            }
            contador++;
        }
        return cota;
    }

    public Point2D getCotaPrimer(int x0, int y0, Pieza[][] tablero) {
        Point2D cota = new Point2D.Double(x0, y0);
        boolean cambiado = false;
        int contador = 0;
        while(!cambiado && x0 + contador + 1 < 8 && y0 - contador - 1>= 0) {
            if (tablero[y0-contador-1][x0+contador+1] != null) {
                if (tablero[y0-contador-1][x0+contador+1].isJugadorA() != isJugadorA()) {
                    cota.setLocation(x0 + contador + 1, y0-contador-1);
                } else {
                    cota.setLocation(x0 + contador, y0-contador);
                }
                cambiado = true;
            } else if (x0 + contador + 1 == 7 || y0 - contador - 1 == 0) {
                cota.setLocation(x0 + contador + 1, y0 - contador -1);
            }
            contador++;
        }
        return cota;
    }

    public Point2D getCotaTercer(int x0, int y0, Pieza[][] tablero) {
        Point2D cota = new Point2D.Double(x0, y0);
        boolean cambiado = false;
        int contador = 0;
        while(y0 + 1 + contador < 8 && x0 + 1 + contador < 8 && !cambiado) {
            if (tablero[y0+1+contador][x0+contador+1] != null) {
                if (tablero[y0+1+contador][x0+contador+1].isJugadorA() != isJugadorA())
                    cota.setLocation(x0 + 1 + contador, y0 + 1 + contador);
                else cota.setLocation(x0 + contador, y0 + contador);
                cambiado = true;
            } else if (x0 + 1 + contador == 7 || y0 + 1 + contador == 7) {
                cota.setLocation(x0 + 1 + contador, y0 + 1 + contador);
            }
            contador++;
        }
        return cota;
    }

    public Point2D getCotaCuarto(int x0, int y0, Pieza[][] tablero) {
        Point2D cota = new Point2D.Double(x0, y0);
        boolean cambiado = false;
        int contador = 0;
        while(y0 + 1 + contador < 8 && x0 - 1 - contador >= 0 && !cambiado) {
            if (tablero[y0+1+contador][x0-contador-1] != null) {
                if (tablero[y0+1+contador][x0-contador-1].isJugadorA() != isJugadorA())
                    cota.setLocation(x0 - 1 - contador, y0 + 1 + contador);
                else cota.setLocation(x0 - contador, y0 + contador);
                cambiado = true;
            } else if (x0 - 1 - contador == 0 || y0 + 1 + contador == 7) {
                cota.setLocation(x0 - 1 - contador, y0 + 1 + contador);
            }
            contador++;
        }
        return cota;
    }

    public boolean torre(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        int cotad = getCotaDerecha(x0, y0, tablero);
        int cotai = getCotaIzquierda(x0, y0, tablero);
        int cotain = getCotaInfer(x0, y0, tablero);
        int cotasu = getCotaSuper(x0, y0, tablero);
        return (x0 == x1 && y0 != y1 && y1 < cotain && y1 > cotasu) || (y0 == y1 && x0 != x1 && x1 < cotad && x1 > cotai);
    }

    public boolean alfil(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        Point2D aux = getCotaPrimer(x0, y0, tablero);
        int primerY = (int) aux.getY(); int primerX = (int) aux.getX();
        aux = getCotaSegun(x0, y0, tablero);
        int segunX = (int) aux.getX(); int segunY = (int) aux.getY();
        aux = getCotaTercer(x0, y0, tablero);
        int tercerX = (int) aux.getX(); int tercerY = (int) aux.getY();
        aux = getCotaCuarto(x0, y0, tablero);
        int cuartoX = (int) aux.getX(); int cuartoY = (int) aux.getY();
        return x0 != x1 && y0 != y1 && ((x1 + y1 == x0 + y0 && x1 <= primerX && y1 >= primerY && x1 >= cuartoX && y1 <= cuartoY) || (x1 - y1 == x0 - y0 && x1 >= segunX && y1 >= segunY && x1 <= tercerX && y1 <= tercerY));
    }





    public abstract String toString();

    public abstract boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero);
}
