import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected List<GameObject> objs = new ArrayList<GameObject>();
    // make protected after testing
    protected Vector offset = Vector.zero();
    protected GameMap map;

    public void update() {
        map.update();
        for (GameObject obj : objs) {
            obj.update();
        }
    }

    protected void setOffset(Vector offset){
        this.offset = offset;
    }

    public void render(Renderer renderer) {
        renderer.setOffset(offset);
        map.render(renderer);
        for (GameObject obj : objs) {
            obj.render(renderer);
        }
    }
}
