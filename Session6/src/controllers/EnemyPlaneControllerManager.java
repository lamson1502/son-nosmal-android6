package controllers;
import models.EnemyBullet;

import java.util.Random;


/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    private int sleep = 50;

    public int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



    public EnemyPlaneControllerManager() {
        super();
//        for(int i = 0; i < 10; i++) {
//            int y = 35;
//            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
//            EnemyPlaneController enemyPlaneController = EnemyPlaneController.create(x, y, EnemyPlaneType.GRAY);
//            baseControllers.add(enemyPlaneController);
//        }
//
//        for(int i = 10; i < 20; i++) {
//            int y = 35;
//            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
//            EnemyPlaneController enemyPlaneController = EnemyPlaneController.create(x, y, EnemyPlaneType.YELLOW);
//            baseControllers.add(enemyPlaneController);
//        }
    }

    @Override
    public void run() {
        super.run();
        if (sleep >= 100) {
            sleep = 0;
            int x = rand(0, 570);
            int colorPlane = rand(0, 2);
            EnemyPlaneController enemyPlaneController;
            if (colorPlane == 0) {
                enemyPlaneController = EnemyPlaneController.create(x, 0, EnemyPlaneType.GRAY);
            } else if (colorPlane == 1) {
                enemyPlaneController = EnemyPlaneController.create(x, 0, EnemyPlaneType.RED);
            } else {
                enemyPlaneController = EnemyPlaneController.create(x, 0, EnemyPlaneType.YELLOW);
            }
                baseControllers.add(enemyPlaneController);
        }
        sleep++;
    }
}
