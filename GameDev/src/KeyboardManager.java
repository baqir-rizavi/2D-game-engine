import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {

    public boolean[] pressedKeys;

    public KeyboardManager() {
        pressedKeys = new boolean[128];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        pressedKeys[e.getKeyChar()] = true;

    }

    @Override
    public void keyPressed(KeyEvent e) {    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() < 128)
            pressedKeys[e.getKeyChar()] = false;
    }
}
