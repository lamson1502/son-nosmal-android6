package controllers;

import model.MyBullet;
import model.MyPlane;
import utils.Utils;
import view.BulletView;
import view.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by lamso on 10/10/2016.
 */
public class PlaneController {
    private MyPlane myPlane;
    private PlaneView planeView;

    ArrayList<MyBulletController> bulletControllers = new ArrayList<MyBulletController>();
    private int dx, dy;
    public static final int SPEED = 8;
    MyBullet bullet;




/**********************CONSTRUCTORS*******************/

    public PlaneController(MyPlane myPlane, PlaneView planeView){
        this.myPlane = myPlane;
        this.planeView = planeView;
    }


    public void addBulletController(){
        MyBulletController bulletController = new MyBulletController(
                new MyBullet(myPlane.getX() + myPlane.getMiddleWidth() - bullet.BULLET_WIDTH / 2,
                        myPlane.getY() + myPlane.getMiddleHeight() - bullet.BULLET_HEIGHT),
                new BulletView(Utils.loadImageFromRes("bullet.png")));
        bulletControllers.add(bulletController);
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

    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
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
        myPlane.moveTo(e.getX() - (myPlane.PLANE_WIDTH / 2), e.getY() - (myPlane.PLANE_HEIGHT / 2));
    }

    public void mouseReleased(MouseEvent e){
        addBulletController();
    }


    public void run(){
        myPlane.move(dx, dy);
        if(bulletControllers != null){
            for(int i = 0; i < bulletControllers.size(); i++){
                bulletControllers.get(i).fly();
            }

        }
    }

    public void drawPlane(Graphics g){
        planeView.drawImage(g, myPlane);
        for(int i = 0; i < bulletControllers.size(); i++)
            bulletControllers.get(i).draw(g);
    }

}
