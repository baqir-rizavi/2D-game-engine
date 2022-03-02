import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    private final static int HEIGHT = 420;
    private final static int WIDTH = 900;
    private final static int SCALE = 2;
    private final static Vector dimention = new Vector(WIDTH, HEIGHT);

    public static boolean running = false;

    JFrame frame = new JFrame();
    String title = "Game";
    Renderer renderer = new Renderer();
    Level level = new TestLevel();

    public Game() {
        running = true;
        addListeners();
        requestFocus();
        this.setPreferredSize(new Dimension(WIDTH * SCALE,HEIGHT * SCALE));
        setFrame();
    }

    private void addListeners() {
        addKeyListener(InputManager.kb);
        addMouseListener(InputManager.mm);
        addMouseMotionListener(InputManager.mm);
        // TODO: add more listeners
    }

    private void setFrame() {
        frame.add(this);
        frame.setTitle(title);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void run() {

        Clock.start();
        long timer = System.currentTimeMillis();

        while (running){

            Clock.updateFps();
            while (Clock.timeToUpdate()) {
                update();
                //System.out.println("hfhrf");
                Clock.updateUps();
            }

            render();
            renderer.clearScreen();

            if (System.currentTimeMillis() - timer > 1000){
                timer+=1000;
                //System.out.println("gdkuydr");
                frame.setTitle(title + " fps: " + Clock.getAndResetFps() + " ups: " + Clock.getAndResetUps());
            }
        }

    }

    private void update() {
        level.update();
    }

    private void render() {
        level.render(renderer);


        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(renderer.getScreen(), 0,0,WIDTH * SCALE, HEIGHT * SCALE,null);
        g.dispose();
        bs.show();

    }

    public void stop() {
        running = false;
    }

    public static int getWindowWidth() { return WIDTH; }

    public static int getWindowHeight() { return HEIGHT; }

    public static int getWindowScale() { return SCALE; }

    public static Vector getDimention() {
        return dimention;
    }
}
