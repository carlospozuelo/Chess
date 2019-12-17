import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rey extends Pieza {

    Rey(boolean jugadorA) {
        super(jugadorA);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(new File("src/images/" + (super.isJugadorA()?"Black":"White") + "King.png"));
    }

    @Override
    public boolean aceptable(int x0, int y0, int x, int y, Pieza[][] tablero) {
        if (x0 == x + 1 && y0 == y + 1 ) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x + 1 && y0 == y) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x + 1 && y0 == y - 1 ) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x - 1 && y0 == y + 1) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x - 1 && y0 == y) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x - 1 && y0 == y - 1) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x && y0 == y + 1) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        if (x0 == x && y0 == y - 1) {
            return tablero[y][x] == null || tablero[y][x].isJugadorA() != isJugadorA();
        }
        return false;
    }
}
