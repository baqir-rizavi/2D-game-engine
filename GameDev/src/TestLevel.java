public class TestLevel extends Level {

    Actor mainChar = new TestCharacter();

    public TestLevel() {
        map = new GameMap();
        map.backgroundSprite = new Sprite("/bg.png", 1);
        objs.add(mainChar);

    }

    @Override
    public void update() {
        setOffset(mainChar.position);
        System.out.println(mainChar.position.x + " " + mainChar.position.y + " | " + Renderer.getOffset().x + " " + Renderer.getOffset().y);


        super.update();
    }

    @Override
    public void render(Renderer renderer) {
        super.render(renderer);
    }
}
