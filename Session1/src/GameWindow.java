import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by apple on 10/2/16.
 */
public class GameWindow extends Frame {
    Image backgroundImage = null;
    Image plane;
    private int planeX = 350;
    private int planeY = 250;
    Image plane2;
    private int plane2X = 100;
    private int plane2Y = 100;

    public GameWindow() {
        this.setVisible(true);
        this.setSize(600, 400);

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

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        System.out.println("Key right");
                        planeX += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY +=10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        planeY -= 10;
                        repaint();
                        break;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                    plane2X = e.getX() - 10;
                    plane2Y = e.getY() - 10;
                    repaint();
            }
        });
        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));
            plane = ImageIO.read(new File("resources/plane3.png"));
            plane2 = ImageIO.read(new File("resources/plane2.png"));
            System.out.println("Loaded backgroundImage");
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("draw background image");
        g.drawImage(backgroundImage, 0, 0, 600, 400, null);
        g.drawImage(plane, planeX, planeY, 50, 30, null);
        g.drawImage(plane2, plane2X, plane2Y, 50, 30, null);
    }
}