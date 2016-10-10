package controllers;

import model.Enemies;
import model.EnemiesBullet;
import model.MyBullet;
import view.BulletView;
import view.EnemiesBulletView;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class EnemiesBulletController {
    public static final int SPEED = 10;
    private EnemiesBullet bullet;
    private EnemiesBulletView bulletView;


    public EnemiesBulletController(EnemiesBullet bullet, EnemiesBulletView bulletView){
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
