package controllers;

import models.GameObject;

/**
 * Created by lamso on 10/21/2016.
 */
public class FollowFlyBehavior implements FlyBehavior{
    private int speed;
    private int plane1X;
    private int plane1Y;
    private int speedX;
    public FollowFlyBehavior(int speed){
        this.speed = speed;
    }
    @Override
    public void doFly(GameObject gameObject) {
        plane1X = PlaneController.planeController.getGameObject().getX();
        plane1Y = PlaneController.planeController.getGameObject().getY();
        int pointX = gameObject.getX();
        int pointY = gameObject.getY();
        int x = Math.abs(plane1X - pointX);
        int y = Math.abs(plane1Y - pointY);
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double f = speed / distance;
        speedX = (int) (f*x);
        gameObject.move(speedX, speed);
    }
}