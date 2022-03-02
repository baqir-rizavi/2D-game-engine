public class GameManager {
    public static Vector screenToWorld(Vector vector) {
        return vector.add(Renderer.getOffset());
    }
}
