package model;

import controllers.MyBulletController;

/**
 * Created by lamso on 10/10/2016.
 */
public class MyPlane {
    public static final int PLANE_HEIGHT = 35;
    public static final int PLANE_WIDTH = 50;
    private int x, y;


/***************CONSTRUCTOR*****************/
    public MyPlane(int x, int y){
        this.x = x;
        this.y = y;
    }
/**************GETTERS***********/

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public void moveTo(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getMiddleWidth(){
        return (PLANE_WIDTH / 2);
    }

    public int getMiddleHeight() {
        return PLANE_HEIGHT / 2;
    }

}


