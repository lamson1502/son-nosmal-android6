package controllers;

import models.EnemiesBullet;
import models.GameConfig;
import models.GameObject;
import models.MyBullet;
import utils.Utils;
import view.GameView;

import java.awt.*;

/**
 * Created by lamso on 10/12/2016.
 */
public class EnemyPlaneController extends SingleController implements Contactable {
    private ControllerManager enemiesBulletControllerManager;

    private int count = 2;
    public static final int SPEED_FLY = 1;

    public EnemyPlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        enemiesBulletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
    }


    public void addBullet(){
        EnemyBulletController enemiesBulletController = new EnemyBulletController(
                new EnemiesBullet(gameObject.getX(), gameObject.getY() + gameObject.getMiddleHeight()),
                new GameView(Utils.loadImageFromRes("enemy_bullet.png")));
        enemiesBulletControllerManager.add(enemiesBulletController);
    }

    @Override
    public void run() {
        super.run();
        gameObject.move(0, SPEED_FLY);
        enemiesBulletControllerManager.run();
        if(GameConfig.instance.getSeconds(count) >= 2){
            count = 0;
            addBullet();
        }
        count++;
        //        controllerManager.checkRange(600, 300);

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        enemiesBulletControllerManager.draw(g);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof MyBulletController){
            contactable.getGameObject().destroy();
        }
    }
}




