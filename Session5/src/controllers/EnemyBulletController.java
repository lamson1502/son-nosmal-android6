package controllers;

import models.GameObject;
import view.GameView;

/**
 * Created by lamso on 10/10/2016.
 */
public class EnemyBulletController extends SingleController implements Contactable{
    public static final int SPEED = 5;

    public EnemyBulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }



    @Override
    public void run() {
        super.run();
        gameObject.move(0, SPEED);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof PlaneController){
            contactable.getGameObject().hit();
        }
    }
}
