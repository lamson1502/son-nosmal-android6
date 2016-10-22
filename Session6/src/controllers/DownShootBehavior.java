package controllers;

import models.GameObject;

/**
 * Created by apple on 10/18/16.
 */

public class DownShootBehavior implements ShootBehavior {
    private int speed;

    public DownShootBehavior(int speed){
        this.speed = speed;
    }
    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {

        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(
                        gameObject.getX(), gameObject.getY(),
                        new DownFlyBehavior(speed));

        bulletControllerManager.add(enemyBulletController);
    }
}
