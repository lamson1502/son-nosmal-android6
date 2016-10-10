package model;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class MyBullet {
    public static final int BULLET_WIDTH = 15;
    public static final int BULLET_HEIGHT = 30;
    public static final int SPEED = 10;


    private int x;
    private int y;


    public MyBullet(int x, int y) {
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
        y -= SPEED;
    }

}


