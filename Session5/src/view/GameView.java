package view;

import models.GameObject;

import java.awt.*;

/**
 * Created by lamso on 10/11/2016.
 */
public class GameView {
    private Image image;


    /*****************CONSTRUCTOR***************/
    public GameView(Image image){
        this.image = image;
    }


    //    GETTERS
    public Image getImage(){
        return image;
    }

    /****************DRAW IMAGE***************/
    public void drawImage(Graphics g, GameObject gameObject){
        g.drawImage(image, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(), null);
    }
}
