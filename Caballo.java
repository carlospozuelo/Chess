import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Caballo extends Pieza {

    Caballo(boolean jugadorA) {
        super(jugadorA);
    }

    @Override
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(new File("src/images/" + (super.isJugadorA()?"Black":"White") + "Knight.png"));
    }

    @Override
    public String toString() {
        return "C";
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        if (x1 == x0 + 1 && y1 == y0 + 2 ) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 + 1 && y1 == y0 - 2) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 - 1 && y1 == y0 + 2 ) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 - 1 && y1 == y0 - 2) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 + 2 && y1 == y0 + 1) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 + 2 && y1 == y0 - 1) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 - 2 && y1 == y0 + 1) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        if (x1 == x0 - 2&& y1 == y0 - 1) {
            return tablero[y1][x1] == null || tablero[y1][x1].isJugadorA() != isJugadorA();
        }
        return false;
    }
}
