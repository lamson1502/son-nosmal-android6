package controllers;

import models.GameObject;
import models.Gift;
import utils.Utils;
import views.GameView;

/**
 * Created by lamso on 10/21/2016.
 */
public class GiftController extends SingleController implements Contactable{
    public int speed = 1;

    public GiftController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }

    @Override
    public void run() {
        super.run();
        gameObject.move(0, speed);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof PlaneController) {
            ((PlaneController) contactable).getGift();
            this.destroy();
        }
    }
}
