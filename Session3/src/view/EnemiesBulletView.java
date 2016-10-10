package view;


import model.EnemiesBullet;
import model.MyBullet;

import java.awt.*;

/**
 * Created by lamso on 10/11/2016.
 */
public class EnemiesBulletView {

    private Image image;


    public EnemiesBulletView(Image image){
        this.image = image;
    }

    public Image getImage(){
        return image;
    }

    public void drawImage(Graphics g, EnemiesBullet bullet) {
        g.drawImage(image, bullet.getX(), bullet.getY(), bullet.BULLET_WIDTH, bullet.BULLET_HEIGHT, null);
    }
}
