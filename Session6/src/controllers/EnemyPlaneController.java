package controllers;

import jdk.nashorn.internal.ir.EmptyNode;
import models.Bullet;
import models.EnemyPlane;
import models.GameConfig;
import models.GameObject;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneController extends SingleController implements Contactable {


    private ControllerManager butlletControllerManager;

    private int count = 1000;

    private FlyBehavior flyBehavior;
    private ShootBehavior shootBehavior;


    public EnemyPlaneController(GameObject gameObject, GameView gameView,
                                FlyBehavior flyBehavior,
                                ShootBehavior shootBehavior) {
        super(gameObject, gameView);
        this.flyBehavior = flyBehavior;
        this.shootBehavior = shootBehavior;

        butlletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        butlletControllerManager.draw(g);
    }




    @Override
    public void run() {
        // Fly
        // Needs game object
        //gameObject.move(0, SPEED);
        if(flyBehavior != null) {
            this.flyBehavior.doFly(this.gameObject);
        }
        // End Fly


        // Shot
        // Needs: count, butletControllerManager
        count++;
        if (GameConfig.instance.getSeconds(count) > 2) {
            count = 0;
            if (shootBehavior != null) {
                shootBehavior.doShoot(this.gameObject, this.butlletControllerManager);
            }
//            EnemyBulletController bulletController = new EnemyBulletController(
//                    new Bullet(gameObject.getMiddleX() - Bullet.BULLET_WIDTH / 2, gameObject.getBottom()),
//                    new GameView(Utils.loadImageFromRes("enemy_bullet.png")
//                    ));
//            butletControllerManager.add(bulletController);
        }
        // End Shot

        butlletControllerManager.run();
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
        }
    }

    public static EnemyPlaneController create(int x, int y, EnemyPlaneType enemyPlaneType) {
        FlyBehavior flyBehavior = null;
        ShootBehavior shootBehavior = null;
        Image image = null;
        if (enemyPlaneType == enemyPlaneType.GRAY) {
            image = Utils.loadImageFromRes("plane1.png");
            flyBehavior = new DownLeftFlyBehavior(1);
            shootBehavior = new DownRightShootBehavior(2);
        }
        if (enemyPlaneType == enemyPlaneType.RED) {
            image = Utils.loadImageFromRes("enemy_plane_white_2.png");
            flyBehavior = new DownRightFlyBehavior(1);
            shootBehavior = new DownLeftShootBehavior(2);
        }
        if (enemyPlaneType == enemyPlaneType.YELLOW){
            image = Utils.loadImageFromRes("enemy_plane_yellow_2.png");
            flyBehavior = new DownFlyBehavior(1);
            shootBehavior = new FollowShootBehavior(4);
        }
        return new EnemyPlaneController(
                new EnemyPlane(x, y),
                new GameView(image),
                flyBehavior,
                shootBehavior);
    }

}
