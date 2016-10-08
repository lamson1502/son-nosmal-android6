import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lamso on 10/2/16.
 */
public class GameWindow extends Frame implements Runnable {

    private static final int BACKGROUND_WIDTH = 600;
    private static final int BACKGROUND_HEIGHT = 400;
    public static final int PLANE_WIDTH = 50;
    public static final int PLANE_HEIGHT = 35;

    Image backgroundImage;
    Image backBufferImage;

    Plane plane1;
    Plane plane2;

    ArrayList<Enemies> planeEnemies = new ArrayList<Enemies>();

    String linkPlane1 = "resources/plane2.png";
    String linkPlane2 = "resources/plane4.png";
    String linkBackGround = "resources/background.png";
    String linkEnemyPlane = "resources/enemy_plane_white_2.png";

    int timeSleepEnemy = 0;

    Enemies enemy;

    public int rand() {
        try {
            Random rn = new Random();
            int range = (BACKGROUND_WIDTH - PLANE_WIDTH) - PLANE_WIDTH + 1;
            int randomNum = PLANE_WIDTH + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }



    public GameWindow() {



/***********************CREATE BACK BUFFER****************************/

        backBufferImage = new BufferedImage(BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int i = 0;




/*******************INIT MY PLANE, ENEMY PLANE, BACKGROUND***************************/
        try {
            plane1 = new Plane(350, 250,
                    ImageIO.read(new File(linkPlane1)));
            plane2 = new Plane(450, 250,
                    ImageIO.read(new File(linkPlane2)));
            backgroundImage = ImageIO.read (
                        new File(linkBackGround));
            enemy = new Enemies(rand(), 0,
                    ImageIO.read(new File(linkEnemyPlane)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        planeEnemies.add(enemy);



/*************************CREATE UI**********************/

        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);




/*************************HANDLING WINDOW EVENTS*******************/


        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });





/*******************HANDING MOUSE MOVE EVENT**************/



        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.mouseMoved(e);
            }

        });


/******************HANDING MOUSE PRESS, CLICK, etc EVENTS*************/


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                plane2.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



    /***************HANDING KEY EVENTS**********************/
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                plane1.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });




    }


    @Override
/*******************DRAW BACK GROUND*******************/

    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("draw background image");
    }


/********************UPDATE DATA TO BACK BUFFER********************/
    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(backgroundImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);


        /**************************MY PLANE**************************/
        plane1.drawImage(backBufferGraphics);

        if(!plane1.bullets.isEmpty()) {
            for (int i = 0; i < plane1.bullets.size(); i++){
                plane1.bullets.get(i).drawImage(backBufferGraphics);
            }
        }

        plane2.drawImage(backBufferGraphics);

        if(!plane2.bullets.isEmpty()) {
            for (int i = 0; i < plane2.bullets.size(); i++){
                plane2.bullets.get(i).drawImage(backBufferGraphics);
            }
        }

            /************************ENEMY PLANE**********************/
        if(timeSleepEnemy >= 100) {
            timeSleepEnemy = 0;
            try {
                enemy = new Enemies(rand(), 0, ImageIO.read(new File(linkEnemyPlane)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            planeEnemies.add(enemy);
        }
        if(!planeEnemies.isEmpty()) {
            for(int i = 0; i < planeEnemies.size(); i++) {
                planeEnemies.get(i).autoCreateBullets();
                planeEnemies.get(i).autoFly();
                planeEnemies.get(i).drawImage(backBufferGraphics);
                for (int j = 0; j < planeEnemies.get(i).bullets.size(); j++) {
                    planeEnemies.get(i).bullets.get(j).drawImage(backBufferGraphics);
                }
            }
        }




        g.drawImage(backBufferImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }


/*********************RUN PROGRAM***********************/

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(17);
                if(plane1 != null) {
                    if (!plane1.bullets.isEmpty()) {
                        for (int i = 0; i < plane1.bullets.size(); i++)
                            plane1.bullets.get(i).shoot();
                    }
                }
                if(plane2 != null) {
                    if (!plane2.bullets.isEmpty()) {
                        for (int i = 0; i < plane2.bullets.size(); i++)
                            plane2.bullets.get(i).shoot();
                    }
                }

                if (!planeEnemies.isEmpty()) {
                    timeSleepEnemy++;
                    for(int i = 0; i < planeEnemies.size(); i++) {
                        planeEnemies.get(i).setTimeSleep(planeEnemies.get(i).getTimeSleep());
                        for (int j = 0; j < planeEnemies.get(i).bullets.size(); j++) {
                            planeEnemies.get(i).bullets.get(j).enemyShoot();
                        }
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}