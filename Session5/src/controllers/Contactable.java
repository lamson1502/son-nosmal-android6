package controllers;

import models.GameObject;

/**
 * Created by lamso on 10/17/2016.
 */
public interface Contactable {
    GameObject getGameObject();
    void onCollide(Contactable contactable);

}
