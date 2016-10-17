
package controllers;

import models.GameConfig;
import models.GameObject;
import view.GameView;

import java.awt.*;

/**
 * Created by lamso on 10/11/2016.
 */

public class SingleController implements BaseController{
    protected GameObject gameObject;
    protected GameView gameView;

    public SingleController(GameObject gameObject, GameView gameView) {
        this.gameObject = gameObject;
        this.gameView = gameView;
    }


    @Override
    public void run() {
        if(GameConfig.instance.yOutsideScreen(gameObject)){
            gameObject.setALive(false);
        }
    }

    @Override
    public void draw(Graphics g) {
        gameView.drawImage(g, gameObject);
    }



    public GameObject getGameObject() {
        return gameObject;
    }
}