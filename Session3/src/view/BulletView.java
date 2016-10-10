package view;

import model.MyBullet;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class BulletView {

    private Image image;


    public BulletView(Image image){
        this.image = image;
    }

    public Image getImage(){
        return image;
    }

    public void drawImage(Graphics g, MyBullet bullet) {
        g.drawImage(image, bullet.getX(), bullet.getY(), bullet.BULLET_WIDTH, bullet.BULLET_HEIGHT, null);
    }
}
