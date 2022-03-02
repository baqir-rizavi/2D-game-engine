public class Vector {
    public double x = 0.0, y = 0.0;


    private static final Vector up = new Vector(0,-1);
    private static final Vector down = new Vector(0,1);
    private static final Vector right = new Vector(1,0);
    private static final Vector left = new Vector(-1,0);


    public Vector() {}

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector scale(double scalar) { return new Vector(x * scalar, y * scalar); }

    public Vector add(Vector vector) { return new Vector(x + vector.x, y + vector.y); }

    public Vector subtract(Vector vector) { return new Vector(x - vector.x, y - vector.y); }

    public double dotProduct(Vector vector) { return this.x * vector.x + this.y * vector.y; }

    public double crossProduct(Vector vector) {
        //TODO: complete
        return 0;
    }

    public double unitize() {
        //TODO: complete
        return 0;
    }

    public static Vector up() { return up; }
    public static Vector down() { return down; }
    public static Vector right() { return right; }
    public static Vector left() { return left; }
    public static Vector zero() { return new Vector(0,0); }
    public static Vector one() { return new Vector(1,1); }

}
