package model;

/**
 * Created by lamso on 10/11/2016.
 */
public class EnemiesBullet {
    public static final int BULLET_WIDTH = 50;
    public static final int BULLET_HEIGHT = 50;
    public static final int SPEED = 5;


    private int x;
    private int y;


    public EnemiesBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void fly(){

        y += SPEED;
    }
}
