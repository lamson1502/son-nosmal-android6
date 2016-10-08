import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lamso on 10/8/2016.
 */
public class Enemies {
    public static final int PLANE_WIDTH = 50;
    public static final int PLANE_HEIGHT = 35;
    public static final int MAX_TIME_SLEEP = 20;

    String linkBullet = "resources/bullet.png";
    private int x, y;

    private Image image;

    private int timeSleep = 0;

    private int speed = 1;

    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    Bullet bullet = null;

    public Enemies(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    //Getters

    public int getTimeSleep(){ return timeSleep+1; }

    //Setters

    public void setTimeSleep(int timeSleep){
        this.timeSleep = timeSleep;
    }


    public void addBullets(){
        if(timeSleep >= MAX_TIME_SLEEP){
            timeSleep = 0;
            try {

                bullet = new Bullet(x  + PLANE_WIDTH / 2 - 5, y + PLANE_HEIGHT, ImageIO.read(new File(linkBullet)));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            bullets.add(bullet);
        }
    }
    public void autoFly(){
        y += speed;
    }

    public void autoCreateBullets(){
        addBullets();
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, PLANE_WIDTH, PLANE_HEIGHT, null);
    }
}
