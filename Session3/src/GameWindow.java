
import controllers.EnemiesController;

import controllers.PlaneController;
import model.Enemies;
import model.MyPlane;
import utils.Utils;
import view.EnemiesView;
import view.PlaneView;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by lamso on 10/10/2016.
 */
public class GameWindow extends Frame implements Runnable {
    public static final int BACKGROUND_HEIGHT = 400;
    public static final int BACKGROUND_WIDTH = 600;

    Image imageBackGround = null;
    Image backBufferImage;

    PlaneController planeController1;
    PlaneController planeController2;

    ArrayList<EnemiesController> enemiesControllers = new ArrayList<EnemiesController>();

    EnemiesController enemiesController;



    public GameWindow(){
        planeController1 = new PlaneController(new MyPlane(BACKGROUND_WIDTH / 3,
                BACKGROUND_HEIGHT - MyPlane.PLANE_HEIGHT),
                new PlaneView(Utils.loadImageFromRes("plane2.png")));
        planeController2 = new PlaneController(new MyPlane(BACKGROUND_WIDTH / 3,
                BACKGROUND_HEIGHT - MyPlane.PLANE_HEIGHT),
                new PlaneView(Utils.loadImageFromRes("plane4.png")));
        for(int i = 0; i < 6; i++) {
            enemiesController = new EnemiesController(new Enemies(50*i, 0), new EnemiesView(Utils.loadImageFromRes("enemy_plane_white_2.png")));
            enemiesControllers.add(enemiesController);
        }
        backBufferImage = new BufferedImage(BACKGROUND_WIDTH, BACKGROUND_HEIGHT,
                BufferedImage.TYPE_INT_ARGB);

        imageBackGround = Utils.loadImageFromRes("background.png");

        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

/**********************EFFECTS WINDOW*******************/

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("window Closing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                planeController2.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeController2.mouseMoved(e);

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                planeController1.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                planeController1.keyReleased(e);
            }
        });

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        System.out.println("draw back ground");
    }

    public void update(Graphics g){
        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(imageBackGround,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);

        planeController1.drawPlane(backBufferGraphics);
        planeController2.drawPlane(backBufferGraphics);
        for(int i = 0; i < 6; i++) {
            enemiesControllers.get(i).drawPlane(backBufferGraphics);
        }
        g.drawImage(backBufferImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }



    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(17);
                planeController1.run();
                planeController2.run();
                for(int i = 0; i < 6; i++)
                enemiesControllers.get(i).run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
