package controllers;

import models.GameObject;

/**
 * Created by lamso on 10/21/2016.
 */
public class FollowShootBehavior implements ShootBehavior{

    private int speed;

    public FollowShootBehavior(int speed){
        this.speed = speed;
    }

    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {
        EnemyBulletController enemyBulletController =
                EnemyBulletController.create(gameObject.getX(),
                        gameObject.getY(), new FollowFlyBehavior(speed));

        bulletControllerManager.add(enemyBulletController);
    }
}
