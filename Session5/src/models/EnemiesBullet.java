package models;

/**
 * Created by lamso on 10/11/2016.
 */
public class EnemiesBullet extends GameObject{
    public static final int BULLET_WIDTH = 40;
    public static final int BULLET_HEIGHT = 40;



    /***************CONSTRUCTOR
     * @param x
     * @param y
     *****************/
    public EnemiesBullet(int x, int y) {
        super(x, y, BULLET_WIDTH, BULLET_HEIGHT, 1);
    }
}
