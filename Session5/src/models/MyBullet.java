package models;

import javafx.geometry.HPos;

/**
 * Created by lamso on 10/10/2016.
 */
public class MyBullet extends GameObject {
    public static final int BULLET_WIDTH = 15;
    public static final int BULLET_HEIGHT = 30;


    /***************CONSTRUCTOR
     * @param x
     * @param y
     *****************/
    public MyBullet(int x, int y) {
        super(x, y, BULLET_WIDTH, BULLET_HEIGHT, 1);
    }

}


