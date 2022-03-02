
/*
*
*
*/
public class Clock {

    private static double deltaTime = 0.0; // time b/w current and previous updates
    private static final double updateRate = 60.0/1000000000.0; // in nanoseconds
    private static long prevtime;
    //private static long timer;
    private static int fps = 0;
    private static int ups = 0;

    public static void start() {
        prevtime = System.nanoTime();
        //timer = System.currentTimeMillis();
    }

    public static void updateFps() {
        long curtime = System.nanoTime();
        deltaTime += (curtime - prevtime) * updateRate;
        prevtime = curtime;
        fps++;
    }

    public static void updateUps() {
        ups++;
        deltaTime--;
    }

    public static boolean timeToUpdate() {
        return deltaTime >= 1;
    }

//    public static boolean oneSecondPassed() {
//        long timercpy = timer;
//        timer += 1000;
//        return System.currentTimeMillis() - timercpy > 1000;
//    }

    public static int getAndResetUps() {
        int upscpy = ups;
        ups = 0;
        return upscpy;
    }

    public static int getAndResetFps() {
        int fpscpy = fps;
        fps = 0;
        return fpscpy;
    }
    public static int getUps(){
        return ups;
    }
}
