package controllers;

import model.Enemies;
import model.EnemiesBullet;
import utils.Utils;
import view.EnemiesBulletView;
import view.EnemiesView;

import java.awt.*;
import java.util.ArrayList;



/**
 * Created by lamso on 10/10/2016.
 */
public class EnemiesController {
    Enemies enemies;
    EnemiesView enemiesView;
    public static final int MAX_TIME_SLEEP = 50;
    int timeSleepBullet = MAX_TIME_SLEEP;
    ArrayList<EnemiesBulletController> enemiesBulletControllers = new ArrayList<EnemiesBulletController>();
    EnemiesBulletController enemiesBulletController;

    public EnemiesController(Enemies enemies, EnemiesView enemiesView){
        this.enemies = enemies;
        this.enemiesView = enemiesView;
    }

    public void autoShoot(){
            enemiesBulletController = new EnemiesBulletController(new EnemiesBullet(enemies.getX() ,
                    enemies.getY()), new EnemiesBulletView(Utils.loadImageFromRes("enemy_bullet.png")));
        enemiesBulletControllers.add(enemiesBulletController);
    }


    public void run() {
        enemies.move();
        if(timeSleepBullet >= MAX_TIME_SLEEP){
            timeSleepBullet = 0;
            autoShoot();
        }
        timeSleepBullet++;
        for(int i = 0; i < enemiesBulletControllers.size(); i++){
            enemiesBulletControllers.get(i).fly();
        }

    }


    public void drawPlane(Graphics g){
        enemiesView.drawImage(g, enemies);
        for(int i = 0; i < enemiesBulletControllers.size(); i++)
            enemiesBulletControllers.get(i).draw(g);
    }

}
