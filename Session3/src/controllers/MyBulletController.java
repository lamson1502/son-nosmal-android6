package controllers;

import model.MyBullet;
import model.Enemies;
import view.BulletView;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class MyBulletController {
    public static final int SPEED = 10;
    private MyBullet bullet;
    private BulletView bulletView;


    public MyBulletController(MyBullet bullet, BulletView bulletView){
        this.bullet = bullet;
        this.bulletView = bulletView;
    }

    public void fly(){
        bullet.fly();
    }

    public void draw(Graphics g){
        bulletView.drawImage(g, bullet);
    }
}
