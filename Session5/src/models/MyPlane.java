package models;

/**
 * Created by lamso on 10/10/2016.
 */
public class MyPlane extends GameObject {
    public static final int PLANE_HEIGHT = 35;
    public static final int PLANE_WIDTH = 50;

    /***************CONSTRUCTOR
     * @param x
     * @param y
    *****************/
    public MyPlane(int x, int y, int HP) {
        super(x, y, PLANE_WIDTH, PLANE_HEIGHT, HP);
    }
}


