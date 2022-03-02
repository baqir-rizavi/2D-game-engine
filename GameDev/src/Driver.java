
public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        Thread loop = new Thread(game);
        loop.start();

    }
}
