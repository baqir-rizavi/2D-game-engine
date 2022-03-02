import java.awt.*;

public abstract class GameObject {

    protected Vector position = new Vector(0,0);
    protected Vector spawnPoint = Game.getDimention().scale(0.5).subtract(new Vector(20,20));
    protected Sprite sprite = null;
    protected boolean fixed = false;
    protected boolean collidable = false;


    public GameObject() {
    }

    public GameObject(Vector position) {
        this.position = position;
    }

    public GameObject(Sprite sprite) {
        this.sprite = sprite;
    }

    public GameObject(Vector position, Sprite sprite) {
        this.sprite = sprite;
        this.position = position;
    }

    public void update() {
        System.out.println(spawnPoint.x + " " +spawnPoint.y);
    }

    public void render(Renderer renderer) {
        if (sprite != null)
            renderer.render((int)spawnPoint.x, (int)spawnPoint.y, sprite, 0xFFFFFFFF, fixed);
    }
    


}
