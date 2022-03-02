public class TestCharacter extends Actor {

    public TestCharacter() {
        sprite = new Sprite("/img.png",1);
        linearSpeed = 5.5;
        System.out.println(position.x + " " + position.y);
    }

    @Override
    public void update() {
        addMover(MoveKeys.BOTH);
        super.update();
    }

}
