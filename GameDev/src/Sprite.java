import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//TODO: handle image scale
public class Sprite {
    private int width;
    private int height;
    private Vector centre;
    int[] pixels;

    public Sprite(String path, int scale) {
        try {
            BufferedImage img = ImageIO.read(this.getClass().getResource(path));
            width = img.getWidth();
            height = img.getHeight();
            pixels = new int[width * height];
            centre = new Vector(width >> 1,height >> 1);
            img.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vector getCentre() { return centre; }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
