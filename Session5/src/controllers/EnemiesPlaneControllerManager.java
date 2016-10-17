package controllers;

import models.Enemies;
import utils.Utils;
import view.GameView;

import java.awt.*;
import java.util.Random;

/**
 * Created by lamso on 10/12/2016.
 */
public class EnemiesPlaneControllerManager extends ControllerManager {
    ControllerManager enemiesControllerManager = new ControllerManager();
    public static final int BACKGROUND_WIDTH = 600;
    public int time = 100;
    public static final int TIME_BORN = 100;



    public int rand() {
        try {
            Random rn = new Random();
            int range = (BACKGROUND_WIDTH - Enemies.PLANE_WIDTH) - Enemies.PLANE_WIDTH + 1;
            int randomNum = Enemies.PLANE_WIDTH + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void run() {
        super.run();
        if(time >= TIME_BORN){
            time = 0;
            EnemyPlaneController enemyPlaneController = new EnemyPlaneController(new Enemies(rand(), 0, 2),
                    new GameView(Utils.loadImageFromRes("enemy_plane_white_2.png")));
            enemiesControllerManager.add(enemyPlaneController);
        }
        time++;
        enemiesControllerManager.run();

        //controllerManager.checkRange(600, 300);

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        enemiesControllerManager.draw(g);
        //controllerManager.checkRange(600, 300);
    }
}
