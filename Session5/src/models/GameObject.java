package models;

import java.awt.*;

/**
 * Created by lamso on 10/11/2016.
 */
public class GameObject {
    private int width;
    private int height;
    private int x, y;
    private boolean isAlive;
    private int HP;


    /***************CONSTRUCTOR*****************/
    public GameObject(int x, int y, int width, int height, int HP){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.isAlive = true;
        this.HP = HP;
    }
    /**************GETTERS***********/

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHP(){
        return HP;
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
        return (width / 2);
    }

    public int getMiddleHeight() {
        return height / 2;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isAlive() {
        return isAlive;
    }

    private Rectangle getRect(){
        return new Rectangle(x, y, width, height);
    }

    public boolean checkCollideWith(GameObject gameObject){
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }


    public void setALive(boolean ALive) {
        this.isAlive = ALive;
    }

    public void hit(){
        if(HP <= 0){
            isAlive = false;
        }
        else {
            HP--;
            isAlive = true;
        }
    }

    public void destroy(){
        isAlive = false;
    }
}
