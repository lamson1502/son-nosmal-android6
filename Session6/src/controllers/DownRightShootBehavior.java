package controllers;

import models.GameObject;
import views.GameView;

/**
 * Created by lamso on 10/21/2016.
 */
public class DownRightShootBehavior implements ShootBehavior {
    private int speed;

    public DownRightShootBehavior(int speed){
        this.speed = speed;
    }

    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {
        EnemyBulletController enemyBulletController = EnemyBulletController.create(
                gameObject.getX(), gameObject.getY(),  new DownRightFlyBehavior(speed));
        bulletControllerManager.add(enemyBulletController);
    }
}
