package model;

/**
 * Created by lamso on 10/10/2016.
 */
public class Enemies {
    public static final int PLANE_HEIGHT = 35;
    public static final int PLANE_WIDTH = 50;
    public static final int SPEED = 1;
    private int x, y;


    public Enemies(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(){
        y += SPEED;
    }

    public int getMiddleWidth(){
        return PLANE_WIDTH / 2;
    }


}
