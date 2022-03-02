
public class GameMap {

    public Sprite backgroundSprite;

    public void update() {

    }

    public void render(Renderer renderer) {
        if (backgroundSprite != null)
            renderer.renderMap(backgroundSprite);
    }

}
