package view;

import model.MyPlane;

import java.awt.*;

/**
 * Created by lamso on 10/10/2016.
 */
public class PlaneView {
    private Image image;

/*****************CONSTRUCTOR***************/
    public PlaneView(Image image){
        this.image = image;
    }


//    GETTERS
    public Image getImage(){
        return image;
    }

/****************DRAW IMAGE***************/
    public void drawImage(Graphics g, MyPlane myPlane){
        g.drawImage(image, myPlane.getX(), myPlane.getY(),
                myPlane.PLANE_WIDTH, myPlane.PLANE_HEIGHT, null);
    }
}


