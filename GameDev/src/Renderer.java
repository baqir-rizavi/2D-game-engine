import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Renderer {

    private int[] pixels;
    private BufferedImage screen;
    private static Vector offset = Vector.zero();
    private static int gameWidth = Game.getWindowWidth(), gameHeight = Game.getWindowHeight();

    public Renderer() {
        pixels = new int[Game.getWindowWidth() * Game.getWindowHeight()];
        screen = new BufferedImage(Game.getWindowWidth(), Game.getWindowHeight(), BufferedImage.TYPE_INT_RGB);

        pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();
        clearScreen();
    }

    public void clearScreen() {
        Arrays.fill(pixels, 0);
    }

    public void render(int xscreen, int yscreen, Sprite sprite, int tranparencyColor, boolean fixedOnMap) {
        if (fixedOnMap)
        {
            xscreen -= offset.x;
            yscreen -= offset.y;
        }
        for (int y = 0; y < sprite.getHeight(); y++) {
            int ya = y + yscreen;
            for (int x = 0; x < sprite.getWidth(); x++) {
                int xa = x + xscreen;
                int spriteIndex = x + y * sprite.getWidth();
                if (xa < gameWidth && xa >= 0 && ya < gameHeight && ya >= 0)
                    if (tranparencyColor != sprite.pixels[spriteIndex])
                        pixels[xa + ya * gameWidth] = sprite.pixels[spriteIndex];
            }
        }
    }

    public void renderMap(Sprite sprite) {
        int spriteWidth = sprite.getWidth(), spriteHeight = sprite.getHeight();
        for (int y = 0; y < screen.getHeight(); y++) {
            int ya = (y + (int)offset.y);
            for (int x = 0; x < screen.getWidth(); x++) {
                int xa =  x + (int)offset.x;
                if (xa < spriteWidth && xa >= 0 && ya < spriteHeight && ya >= 0)
                    pixels[x + y * gameWidth] = sprite.pixels[xa + ya * spriteWidth];
            }
        }
    }

    public BufferedImage getScreen() {
        return screen;
    }
    public void setOffset(Vector vector) {
        offset = vector;
    }
    public static Vector getOffset() {
        return offset;
    }
}
