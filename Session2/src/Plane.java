import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lamso on 10/4/16.
 */
public class Plane {

    public static final int PLANE_WIDTH = 50;
    public static final int PLANE_HEIGHT = 35;
    String linkBullet = "resources/bullet.png";
    private int x, y;
    private Image image;

    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    Bullet bullet = null;

    public Plane(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }


    // Gettters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }


    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Key right");
                if(x <= 550)
                    this.x += 10;
                break;
            case KeyEvent.VK_LEFT:
                if(x >= 25)
                    x -= 10;
                break;
            case KeyEvent.VK_UP:
                if(y >= 35)
                    y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                if(y <= 365)
                    y += 10;
                break;
            case KeyEvent.VK_SPACE:
                try {

                    bullet = new Bullet(x  + PLANE_WIDTH / 2 - 5, y, ImageIO.read(new File(linkBullet)));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                bullets.add(bullet);
                break;
        }
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX() - (PLANE_WIDTH / 2);
        y = e.getY() - (PLANE_HEIGHT / 2);
    }

    public void mousePressed(MouseEvent e){
        try {

            bullet = new Bullet(x + PLANE_WIDTH /2 - 5, y, ImageIO.read(new File(linkBullet)));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        bullets.add(bullet);

    }


    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, PLANE_WIDTH, PLANE_HEIGHT, null);
    }
}