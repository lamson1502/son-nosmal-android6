package controllers;

import models.GameObject;

/**
 * Created by lamso on 10/18/2016.
 */
public class DownLeftShootBehavior implements ShootBehavior {
        private int speed;
    public DownLeftShootBehavior(int speed){
        this.speed = speed;
    }

    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {

        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(
                        gameObject.getX(), gameObject.getY(),
                        new DownLeftFlyBehavior(speed));

        bulletControllerManager.add(enemyBulletController);
    }
}
