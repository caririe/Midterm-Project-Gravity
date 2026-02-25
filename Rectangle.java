import java.awt.*;
import java.awt.geom.*;

public class Rectangle implements DrawingObject {

    private double xCoor;
    private double yCoor;
    private double width;
    private double height;
    private Color color;

    public Rectangle(double x, double y, double w, double h, Color c) {
        xCoor = x;
        yCoor = y;
        width = w;
        height = h;
        color = c;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();

        Rectangle2D.Double rect = new Rectangle2D.Double(xCoor, yCoor, width, height);
        g2d.setColor(color);
        g2d.fill(rect);

        g2d.setTransform(reset);

    }

    public void changeColor (Color c) {
        color = c;
    }

    public double getX() {
        return xCoor;
    }

    public double getY() {
        return yCoor;
    }
    
}