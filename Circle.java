import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject{

    private double xCoor;
    private double yCoor;
    private double size;
    private Color color;

    public Circle(double x, double y, double s, Color c) {
        xCoor = x;
        yCoor = y;
        size = s;
        color = c;
        // check how u want to format color
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Ellipse2D.Double circle = new Ellipse2D.Double(xCoor, yCoor, size, size);
        g2d.setColor(color);
        g2d.fill(circle);

        g2d.setTransform(reset);

    }

    public void changeColor(Color c) {
        color = c;
    }


    

    
}
