package controllers;

import models.GameObject;
import models.MyBullet;
import utils.Utils;
import view.GameView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by lamso on 10/10/2016.
 */
public class PlaneController extends SingleController implements Contactable{

//    public ControllerManager bulletControllers = new ControllerManager();
//    public ArrayList<MyBulletController> bulletControllers = new ArrayList<>();
    private ControllerManager bulletManager;
    private int dx, dy;
    public static final int SPEED = 8;
    /**********************CONSTRUCTORS*******************/

    public PlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        bulletManager = new ControllerManager();
        CollisionPool.instance.register(this);
    }


    public void addBulletController() {
        MyBulletController myBulletController = new MyBulletController(
                new MyBullet(gameObject.getX() + gameObject.getMiddleWidth(), gameObject.getY()),
                new GameView(Utils.loadImageFromRes("bullet.png")));
        bulletManager.add(myBulletController);
    }


    /***********************KEY PRESSED*******************/

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                dy = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                dx = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                dx = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Press Space");
                addBulletController();
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;
        }
    }


    public void mouseMoved(MouseEvent e) {
        gameObject.moveTo(e.getX() - (gameObject.getWidth() / 2), e.getY() - (gameObject.getHeight() / 2));
    }

    public void mousePressed(MouseEvent e) {
        addBulletController();
    }


    public void run() {
        super.run();
        gameObject.move(dx, dy);
        bulletManager.run();

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof EnemyBulletController){
            contactable.getGameObject().destroy();
        }
    }
}
