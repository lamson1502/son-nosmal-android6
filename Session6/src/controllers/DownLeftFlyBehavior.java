package controllers;

import models.EnemyPlane;
import models.GameObject;

/**
 * Created by lamso on 10/18/2016.
 */
public class DownLeftFlyBehavior implements FlyBehavior{
    private int speed;
    private boolean limit = true;
    public DownLeftFlyBehavior(int speed) {
        this.speed = speed;
    }

    @Override
    public void doFly(GameObject gameObject) {
        if(limit == true) {
            gameObject.move(-speed, speed);
            if(gameObject.getX() <= 0 && gameObject instanceof EnemyPlane)
                limit = false;
        }
        if(limit == false){
            gameObject.move(speed, speed);
        }

    }
}
