
// TODO: add game-pad and game controller inputs
// TODO: implements inputactionlistener for android
// TODO: add methods: get mouse inputs from mouse manager

public class InputManager {
    static KeyboardManager kb = new KeyboardManager();
    static MouseManager mm = new MouseManager();

    public static boolean isKeyPressed(int keyCode) {

        return kb.pressedKeys[keyCode];
    }
}
