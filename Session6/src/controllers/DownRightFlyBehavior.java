package controllers;

import models.EnemyPlane;
import models.GameConfig;
import models.GameObject;

/**
 * Created by apple on 10/18/16.
 */
public class DownRightFlyBehavior implements FlyBehavior {
    private int speed;
    private boolean limit = true;

    public DownRightFlyBehavior(int speed) {
        this.speed = speed;
    }

    @Override
    public void doFly(GameObject gameObject) {
        if(limit == true) {
            gameObject.move(speed, speed);
            if(gameObject.getX() >= 570 && gameObject instanceof EnemyPlane)
                limit = false;
        }
        if(limit == false){
            gameObject.move(-speed, speed);
        }
    }
}
