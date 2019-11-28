import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeSupport;

public class Controlador implements MouseListener {

    private PropertyChangeSupport support;

    Controlador(PropertyChangeSupport support) {
        this.support = support;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // if (e.getButton() == MouseEvent.BUTTON1) {
        //}
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
