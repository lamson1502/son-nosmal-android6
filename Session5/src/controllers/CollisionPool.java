package controllers;

import models.GameObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lamso on 10/17/2016.
 */
public class CollisionPool implements BaseController {

    ArrayList<Contactable> contactables;

    private CollisionPool(){
        contactables = new ArrayList<>();
    }

    @Override
    public void run() {
        for(int i = 0; i < contactables.size() - 1; i++) {
            for (int j = i + 1; j < contactables.size(); j++) {
                Contactable contactablei = contactables.get(i);
                Contactable contactablej = contactables.get(j);
                GameObject gameObjecti = contactablei.getGameObject();
                GameObject gameObjectj = contactablej.getGameObject();
                if (gameObjecti.checkCollideWith(gameObjectj)) {
                    contactablei.onCollide(contactablej);
                    contactablej.onCollide(contactablei);

                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    public void register(Contactable contactable){
        contactables.add(contactable);
    }

    public static final CollisionPool instance = new CollisionPool();
}
