import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Alfil extends Pieza {

    Alfil(boolean isJugadorA) {
        super(isJugadorA);
    }

    @Override
    public String toString() {
        return "A";
    }

    @Override
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(new File("src/images/" + (super.isJugadorA() ?"Black":"White") + "Bishop.png"));
    }

    @Override
    public boolean aceptable(int x0, int y0, int x1, int y1, Pieza[][] tablero) {
        return alfil(x0, y0, x1, y1, tablero);
    }
}
