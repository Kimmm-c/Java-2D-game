import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean goUp, goDown, goLeft, goRight;

    @Override
    public void keyTyped(KeyEvent e) {
        //could be useful for use input functionality.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();  //return the integer keyCode associated with the key that was pressed.

        if (code == KeyEvent.VK_W) {
            goUp = true;
        }
        if (code == KeyEvent.VK_S) {
            goDown = true;
        }
        if (code == KeyEvent.VK_A) {
            goLeft = true;
        }
        if (code == KeyEvent.VK_D) {
            goRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            goUp = false;
        }
        if (code == KeyEvent.VK_S) {
            goDown = false;
        }
        if (code == KeyEvent.VK_A) {
            goLeft = false;
        }
        if (code == KeyEvent.VK_D) {
            goRight = false;
        }
    }
}
