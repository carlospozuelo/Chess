import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Torre extends Pieza {

    @Override
    public BufferedImage getImage() throws IOException {
        return ImageIO.read(new File("src/images/" + (super.isJugadorA()?"Black":"White") + "Rook.png"));
    }

    Torre(boolean jugadorA) {
         super(jugadorA);
    }

    @Override
    public String toString() {
        return "T";
    }


    @Override
    public boolean aceptable(int x0, int y0, int x, int y, Pieza[][] tablero) {
        return torre(x0, y0, x, y, tablero);
    }
}
