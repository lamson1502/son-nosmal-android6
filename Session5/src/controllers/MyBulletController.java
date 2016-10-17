package controllers;

import models.GameObject;
import view.GameView;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class MyBulletController extends SingleController implements Contactable{
    public static final int SPEED = 15;

    public MyBulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }


    @Override
    public void run(){
        super.run();
        gameObject.move(0, -SPEED);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof EnemyPlaneController){
           contactable.getGameObject().hit();
        }
    }
}
