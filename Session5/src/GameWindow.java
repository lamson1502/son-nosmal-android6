
import controllers.*;

import models.GameConfig;
import models.MyPlane;
import utils.Utils;
import view.GameView;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by lamso on 10/10/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image imageBackGround = null;
    Image backBufferImage;
    PlaneController planeController1;
    PlaneController planeController2;



    private ControllerManager controllerManager;





/**************************CONSTRUCTOR********************/

    public GameWindow(){
        controllerManager = new ControllerManager();
        planeController1 = new PlaneController(
                new MyPlane(GameConfig.instance.getScreenWidth() / 3,
                GameConfig.instance.getScreenHeight() - MyPlane.PLANE_HEIGHT, 5),
                new GameView(Utils.loadImageFromRes("plane2.png")));
        planeController2 = new PlaneController(
                new MyPlane(GameConfig.instance.getScreenWidth() / 3,
                        GameConfig.instance.getScreenHeight() - MyPlane.PLANE_HEIGHT, 5),
                new GameView(Utils.loadImageFromRes("plane4.png")));
        controllerManager.add(planeController1);
        controllerManager.add(planeController2);
        controllerManager.add(new EnemiesPlaneControllerManager());
        controllerManager.add(CollisionPool.instance);
        backBufferImage = new BufferedImage(
                GameConfig.instance.getScreenWidth(), GameConfig.instance.getScreenHeight(),
                BufferedImage.TYPE_INT_ARGB);

        imageBackGround = Utils.loadImageFromRes("background.png");

        this.setVisible(true);
        this.setSize(GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight());

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
/**********************MOUSE CONTROL*********************/
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                planeController2.mousePressed(e);
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

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeController2.mouseMoved(e);

            }
        });
/**********************KEY CONTROL***********************/
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

/************************UPDATE**********************/
    public void update(Graphics g){
        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(imageBackGround,
                0, 0,
                GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight(), null);

        controllerManager.draw(backBufferGraphics);

//        for(int i = 0; i < 6; i++) {
//            enemiesControllers.get(i).drawPlane(backBufferGraphics);
//        }
        g.drawImage(backBufferImage, 0, 0, GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight(), null);
    }


/************************RUN PROGRAM*********************/
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(GameConfig
                        .instance
                        .getThreadDelayInMiliseconds());
                controllerManager.run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
