public abstract class Actor extends GameObject {
    protected double linearSpeed = 1.0;
    protected double rotation = 0.0; // in degrees
    private boolean moving = false;

    public Actor() {
        fixed = false;
        collidable = true;
    }

    protected enum MoveKeys {
        AWSD, ARROWKEYS, BOTH
    }

    @Override
    public void update(){
        super.update();
        if (rotation <= 360.0)
            rotation %= 360.0;
    }

    @Override
    public void render(Renderer renderer) {
        if (!moving)
            super.render(renderer);
        // TODO: complete
    }

    public void addMover(MoveKeys keys) {
        // TODO: complete
        //if (keys == MoveKeys.AWSD){
            if (InputManager.isKeyPressed('w')) position = position.add(Vector.up().scale(linearSpeed));
            if (InputManager.isKeyPressed('s')) position = position.add(Vector.down().scale(linearSpeed));
            if (InputManager.isKeyPressed('a')) position = position.add(Vector.left().scale(linearSpeed));
            if (InputManager.isKeyPressed('d')) position = position.add(Vector.right().scale(linearSpeed));
        //}
    }
}
