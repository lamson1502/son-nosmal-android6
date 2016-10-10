package view;

import model.Enemies;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class EnemiesView {
    private Image image;

    /*****************CONSTRUCTOR***************/
    public EnemiesView(Image image){
        this.image = image;
    }


    //    GETTERS
    public Image getImage(){
        return image;
    }

    /****************DRAW IMAGE***************/
    public void drawImage(Graphics g, Enemies enemies){
        g.drawImage(image, enemies.getX(), enemies.getY(),
                enemies.PLANE_WIDTH, enemies.PLANE_HEIGHT, null);
    }
}
