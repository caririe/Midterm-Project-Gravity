import java.awt.*;
import java.awt.geom.*;

public class Apple implements DrawingObject{

    private double x;
    private double y;
    private Color color;
    private Path2D.Double curvedShape;


    public Apple(double x, double y, Color color) {
        curvedShape = new Path2D.Double();
    }


    @Override
    public void draw(Graphics2D g2d) {

    }

}