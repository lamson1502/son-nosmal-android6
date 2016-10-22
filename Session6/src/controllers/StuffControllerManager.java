package controllers;

import models.Gift;
import utils.Utils;
import views.GameView;

/**
 * Created by lamso on 10/21/2016.
 */
public class StuffControllerManager extends ControllerManager {

    public StuffControllerManager(){
        super();
        GiftController giftController = new GiftController(
                new Gift(200, 0),
                new GameView(Utils.loadImageFromRes("power-up.png")));
        GiftController giftController2 = new GiftController(
                new Gift(400, 0),
                new GameView(Utils.loadImageFromRes("power-up.png")));
        baseControllers.add(giftController);
        baseControllers.add(giftController2);
    }
}
